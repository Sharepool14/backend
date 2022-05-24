package mau.project.sharepool.acceptedloan;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.loanpost.Loan_PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Accepted_loanService {
    private Accepted_loanRepository accepted_loanRepository;
    private CommunityAccountRepository communityAccountRepository;
    private Loan_PostRepository loan_postRepository;

    @Autowired
    public Accepted_loanService(Accepted_loanRepository accepted_loanRepository, CommunityAccountRepository communityAccountRepository, Loan_PostRepository loan_postRepository){
        this.accepted_loanRepository = accepted_loanRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.loan_postRepository = loan_postRepository;
    }

    public void requestLoan(Long postID) {
        Loan_Post loan_post = loan_postRepository.getById(postID);
        if(communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(),loan_post.getCommunity().getId())){
            Account account = new Account();
            account.setId(AccountID.get());
            Loan loan = new Loan(account, loan_post, false, false);
            accepted_loanRepository.save(loan);
        }
    }

    public void rejectLoan(Long loan_id) {
        accepted_loanRepository.deleteById(loan_id);
    }
}
