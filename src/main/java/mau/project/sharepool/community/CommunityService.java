package mau.project.sharepool.community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommunityService {
    private CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository){
        this.communityRepository = communityRepository;
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
}
