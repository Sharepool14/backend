package mau.project.sharepool.community;
import mau.project.sharepool.acceptedloan.LoanRepository;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.invite.Invite;
import mau.project.sharepool.invite.InviteRepository;
import mau.project.sharepool.loanpost.Loan_Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Anthon Haväng
 */
@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityAccountRepository communityAccountRepository;
    private final InviteRepository inviteRepository;
    private final AccountRepository accountRepository;
    private final LoanRepository loanRepository;

    /**
     * @author Anthon Haväng
     * Constructor for this class.
     */
    @Autowired
    public CommunityService(
            CommunityRepository communityRepository,
            CommunityAccountRepository communityAccountRepository,
            InviteRepository inviteRepository,
            AccountRepository accountRepository,
            LoanRepository loanRepository){

        this.inviteRepository = inviteRepository;
        this.communityRepository = communityRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.accountRepository = accountRepository;
        this.loanRepository = loanRepository;
    }

    public List<Community> getCommunities(){
        return communityRepository.findAll();
    }

    public void deleteACommunity(Long id){
        communityRepository.deleteById(id);
    }

    public Set<Community> getAccountCommunities() {
        return communityAccountRepository.findAllByAccountId(AccountID.get()).stream()
                .map(CommunityAccount::getCommunity)
                .collect(Collectors.toSet());
    }

    /**
     * @author Anthon Haväng
     * This method creates a community, and sets the creating user to admin/owner.
     * @param community Saves the provided community to the database with information provided from front-end and
     * assigns the creating user to the role of owner/admin.
     * @return Returns 1 if the creation was a success, and return 2 if the creation failed.
     */
    public int createCommunity(Community community) {
        try {
            communityRepository.save(community);
            Account account = new Account();
            account.setId(AccountID.get());
            communityAccountRepository.save(new CommunityAccount(account, community, 3));
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 2;
        }
    }

    /**
     * @author Anthon Haväng
     * This method returns a Set of accounts with members in a specific community.
     * @param community_id Provided from front-end, used to specify which community to fetch members from in the
     * database.
     * @return Returns the user-accounts of the members in the specified community.
     */
    public Set<Account> getMembersInCommunity(Long community_id) {
        return communityAccountRepository.findAllByCommunityId(community_id).stream()
                  .map(CommunityAccount::getAccount)
                  .collect(Collectors.toSet());
    }

    public Community getACommunity(Long community_id) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), community_id)) {
            return communityRepository.getById(community_id);
        } else return null;
    }

    public void createInvite(Long community_id, String username) {
        if (communityAccountRepository.existsByAccountIdAndCommunityIdAndRoleGreaterThan(AccountID.get(),community_id,1)) {
            Account account = accountRepository.findByUsername(username);
            if (account != null) {
                Account inviter = new Account();
                inviter.setId(AccountID.get());

                Account invitee = new Account();
                invitee.setId(account.getId());

                Community community = new Community();
                community.setId(community_id);
                inviteRepository.save(new Invite(inviter,invitee,community));
            }
        }
    }

    /**
     * @author Anthon Haväng
     * This method returns all the loan posts from a specific community.
     * @param communityID Provided from front-end, used to specify which community to fetch from in the database.
     * @return Returns a set of all the loan posts from the specified community.
     */
    public Set<Loan_Post> getThisCommunitysPosts(Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)){
           return communityRepository.getById(communityID).getLoan_posts();
        } else return null;
    }

    /**
     * @author Anthon Haväng
     * This method is used when a user wants to leave a community they are a member in. The Spring-annotation
     * "@Transactional" is required to refer to the joined table CommunityAccount.
     * @param communityID Provided by the user from front-end, to specify which community they want to leave.
     */
    @Transactional
    public void leaveCommunity(Long communityID) {
        if (communityAccountRepository.getById(AccountID.get()).getAccount().getLoans().isEmpty()){
            communityAccountRepository.deleteByAccount_IdAndCommunity_Id(AccountID.get(), communityID);
        } else if (loanRepository.existsAllByAccount_IdAndReturnedIsFalse(AccountID.get())){
            communityAccountRepository.deleteByAccount_IdAndCommunity_Id(AccountID.get(), communityID);
        }
    }
}
