package mau.project.sharepool.community;
import mau.project.sharepool.acceptedloan.LoanRepository;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.invite.Invite;
import mau.project.sharepool.invite.InviteRepository;
import mau.project.sharepool.loanpost.LoanPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityAccountRepository communityAccountRepository;
    private final InviteRepository inviteRepository;
    private final AccountRepository accountRepository;
    private final LoanRepository loanRepository;

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
     * @param community
     * @return
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
     * @param community_id
     * @return
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
            System.out.println(account.getUsername());
            System.out.println("!!");
            if (account != null) {
                System.out.println("!!!");

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
     * @param communityID
     * @return
     */
    public Set<LoanPost> getThisCommunitysPosts(Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)){
           return communityRepository.getById(communityID).getLoan_posts();
        } else return null;
    }

    /**
     * @author Anthon Haväng
     * @param communityID
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
