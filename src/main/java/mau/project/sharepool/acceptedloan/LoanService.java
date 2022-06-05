
package mau.project.sharepool.acceptedloan;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.loanpost.Loan_PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: Elisabet Aronsson
 */
@Service
public class LoanService {
    private LoanRepository loanRepository;
    private CommunityAccountRepository communityAccountRepository;
    private Loan_PostRepository loan_postRepository;
    private AccountRepository accountRepository;

    /**
     * @author: Elisabet Aronsson
     * @param accepted_loanRepository
     * @param communityAccountRepository
     * @param loan_postRepository
     * @param accountRepository
     */
    @Autowired
    public LoanService(LoanRepository accepted_loanRepository, CommunityAccountRepository communityAccountRepository, Loan_PostRepository loan_postRepository, AccountRepository accountRepository){
        this.loanRepository = accepted_loanRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.loan_postRepository = loan_postRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * @author Elisabet Aronsson
     * @param postID - the loan_post of the item which the user is interested in loaning
     * 1. Finds a loan_post
     * 2. checks if the person requesting is authorized and within the community
     * 3. creates a loan/request
     */
    public void requestLoan(Long postID) {
        Loan_Post loan_post = loan_postRepository.getById(postID);
        if(communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(),loan_post.getCommunity().getId())){
            Account account = new Account();
            account.setId(AccountID.get());
            Account owner = new Account();
            owner.setId(loan_post.getAccount().getId());
            Loan loan = new Loan(owner,account, loan_post, false, false);
            loanRepository.save(loan);
        }
    }

    /**
     * @author Elisabet Aronsson
     * @param loan_id - the loan/request of matter
     * Deletes a request if the owner of the item reject it
     */
    public void rejectLoan(Long loan_id) {
        loanRepository.deleteById(loan_id);
    }

    /***
     * @author Elisabet Aronssonm, Hugo Lindstedt
     * @param loan_id
     * If the request is accepted the visibility will change
     * Sets visible to false for the loan_post and saves loan with accepted = true
     */
    public void acceptLoan(Long loan_id) {
       Loan loan = loanRepository.getById(loan_id);
       loan.getLoan_post().setVisible(false);
       loan.setAccepted(true);
       loanRepository.save(loan);
    }

    /**
     * @author Elisabet Aronsson, Hugo Lindstedt
     * @return Returns all loan requests of your items
     */
    public List<LoanDTO> getPendingLoanReqFromOthers() {
        List<Loan> loans = loanRepository.findAllByAccountId(AccountID.get());
        List <LoanDTO> loanDTOS = new ArrayList<>();
        loans.stream()
                .forEach(loan -> {
                    LoanDTO dto = new LoanDTO();
                    dto.setId(loan.getId());
                    dto.setAccepted(loan.isAccepted());
                    dto.setReturned(loan.isReturned());
                    dto.setItemOwnerName(loan.getAccount().getUsername());
                    dto.setRequesterName(loan.getRequester().getUsername());
                    dto.setLoan_post_id(loan.getLoan_post().getId());
                    dto.setCommunity_id(loan.getLoan_post().getCommunity().getId());
                    loanDTOS.add(dto);
                });
        return loanDTOS;
    }

    /**
     * @author Elisabet Aronsson, Hugo Lindstedt
     * @return All of my requests of others items
     */
    public List<LoanDTO> getMyLoanOrReq() {
        List<Loan> loans = loanRepository.findAllByRequesterId(AccountID.get());
        List<LoanDTO> loanDTOS = new ArrayList<>();
        loans.stream()
                .forEach(loan -> {
                    LoanDTO dto = new LoanDTO();
                    dto.setId(loan.getId());
                    dto.setAccepted(loan.isAccepted());
                    dto.setReturned(loan.isReturned());
                    dto.setItemOwnerName(loan.getAccount().getUsername());
                    dto.setRequesterName(loan.getRequester().getUsername());
                    dto.setLoan_post_id(loan.getLoan_post().getId());
                    loanDTOS.add(dto);
                });
        return loanDTOS;
    }

    /**
     * @author Elisabet Aronsson
     * Deletes a request that you have done on another users loan_post
     * @param loan_id
     */
    public void deleteYourReq(Long loan_id) {
        if(!loanRepository.getById(loan_id).isAccepted() && loanRepository.getById(loan_id).getRequester().equals(AccountID.get())){
            loanRepository.deleteById(loan_id);
        }
    }

    /**
     * @author Elisabet Aronsson
     * The owner of a loaned item rapports if the item has returned
     * @param loan_id
     */
    public void itemReturned(Long loan_id) {
        if(loanRepository.getById(loan_id).getAccount().getId().equals(AccountID.get())){
            Loan loan = loanRepository.getById(loan_id);
            loan.setReturned(true);
            loanRepository.save(loan);
        }
    }
}
