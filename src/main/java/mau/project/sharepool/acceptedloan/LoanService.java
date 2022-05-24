package mau.project.sharepool.acceptedloan;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.loanpost.Loan_PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private CommunityAccountRepository communityAccountRepository;
    private Loan_PostRepository loan_postRepository;

    @Autowired
    public LoanService(LoanRepository accepted_loanRepository, CommunityAccountRepository communityAccountRepository, Loan_PostRepository loan_postRepository){
        this.loanRepository = accepted_loanRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.loan_postRepository = loan_postRepository;
    }

    public void requestLoan(Long postID) {
        Loan_Post loan_post = loan_postRepository.getById(postID);
        if(communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(),loan_post.getCommunity().getId())){
            Account account = new Account();
            account.setId(AccountID.get());
            Loan loan = new Loan(account, loan_post, false, false);
            loanRepository.save(loan);
        }
    }

    public void rejectLoan(Long loan_id) {
        loanRepository.deleteById(loan_id);
    }

    /***
     * Sets visible to false for the loan_post and saves loan with accepted = true
     * @param loan_id
     */
    public void acceptLoan(Long loan_id) {
       Loan loan = loanRepository.getById(loan_id);
       loan.getLoan_post().setVisible(false);
       loan.setAccepted(true);
       loanRepository.save(loan);
    }

    public Set<Loan> getPendingLoanReqFromOthers() {
        return loanRepository.findAllByAccountId(AccountID.get());
    }

    public Set<Loan> getMyLoanOrReq() {
        return loanRepository.findAllByRequesterId(AccountID.get());
    }
}
