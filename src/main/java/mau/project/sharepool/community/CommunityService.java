package mau.project.sharepool.community;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.invite.Invite;
import mau.project.sharepool.invite.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityAccountRepository communityAccountRepository;
    private final InviteRepository inviteRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CommunityService(
            CommunityRepository communityRepository,
            CommunityAccountRepository communityAccountRepository,
            InviteRepository inviteRepository,
            AccountRepository accountRepository){

        this.inviteRepository = inviteRepository;
        this.communityRepository = communityRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.accountRepository = accountRepository;
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

    public int createCommunity(Community community, Long accountID) {
        try {
            communityRepository.save(community);
            Account account = new Account();
            account.setId(accountID);
            communityAccountRepository.save(new CommunityAccount(account, community, 3));
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 2;
        }
    }

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
}
