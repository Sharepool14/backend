package mau.project.sharepool.community;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountKey;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityService {
    private CommunityRepository communityRepository;
    private CommunityAccountRepository communityAccountRepository;
    private AccountRepository accountRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository, CommunityAccountRepository communityAccountRepository){
        this.communityRepository = communityRepository;
        this.communityAccountRepository = communityAccountRepository;
    }

    public List<Community> getCommunities(){
        return communityRepository.findAll();
    }

    public void addToCommunity(Community community){
        communityRepository.save(community);
    }

    public void deleteACommunity(Long id){
        communityRepository.deleteById(id);
    }

    public void deleteAllCommunities(){
        communityRepository.deleteAll();
    }

    public Set<Community> getAccountCommunties(Long id) {
        return communityAccountRepository.findAllByAccountId(id).stream()
                .map(CommunityAccount::getCommunity)
                .collect(Collectors.toSet());
    }

    public int createCommunity(Community community, Long accountID) {
        try {
            System.out.println("Start");
            communityRepository.save(community);
            System.out.println(community.getId());
            Account account = new Account();
            account.setId(accountID);
            //CommunityAccountKey id = new CommunityAccountKey(accountID, community);
            communityAccountRepository.save(new CommunityAccount(account, community, 3));
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 2;
        }
    }
}
