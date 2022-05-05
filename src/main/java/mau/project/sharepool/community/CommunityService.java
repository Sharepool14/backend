package mau.project.sharepool.community;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommunityService {
    private CommunityRepository communityRepository;
    private CommunityAccountRepository communityAccountRepository;

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
}
