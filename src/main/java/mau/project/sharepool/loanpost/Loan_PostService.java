package mau.project.sharepool.loanpost;

import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Loan_PostService {
    private final Loan_PostRepository loan_postRepository;
    private final CommunityAccountRepository communityAccountRepository;

    @Autowired
    private Loan_PostService(Loan_PostRepository loan_postRepository, CommunityAccountRepository communityAccountRepository) {
        this.loan_postRepository = loan_postRepository;
        this.communityAccountRepository = communityAccountRepository;
    }

    public void updatePost(Loan_Post loan_post) {
        Loan_Post loan_post1 = loan_postRepository.getById(loan_post.getId());
        loan_post1.setStart_date(loan_post.getStart_date());
        loan_post1.setReturn_date(loan_post.getReturn_date());
        loan_post1.setItem(loan_post.getItem());
        loan_postRepository.save(loan_post1);
    }

    public List<Loan_Post> all() {
        return loan_postRepository.findAll();
    }

    public void deletePost(Long postID) {
        loan_postRepository.deleteById(postID);
    }

    public List<Loan_Post> communitiesPost(Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            return (List<Loan_Post>) loan_postRepository.findAllByCommunity_id(communityID);
        } else return null;
    }

    public Loan_Post getSpecificPost(Long communityID, Long postID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            return loan_postRepository.getById(postID);
        } else return null;
    }

    public void createPost(Loan_Post loan_post, Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            loan_postRepository.save(loan_post);
        }
    }
}
