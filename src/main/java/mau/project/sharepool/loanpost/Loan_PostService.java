package mau.project.sharepool.loanpost;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.community.Community;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Elisabet Aronsson
 */
@Service
public class Loan_PostService {
    private final Loan_PostRepository loan_postRepository;
    private final CommunityAccountRepository communityAccountRepository;
    private final ItemRepository itemRepository;

    /**
     * @author Elisabet Aronsson
     * @param loan_postRepository
     * @param communityAccountRepository
     * @param itemRepository
     */
    @Autowired
    private Loan_PostService(Loan_PostRepository loan_postRepository, CommunityAccountRepository communityAccountRepository,ItemRepository itemRepository) {
        this.loan_postRepository = loan_postRepository;
        this.communityAccountRepository = communityAccountRepository;
        this.itemRepository = itemRepository;
    }

    public List<Loan_Post> all() {
        List<Long> communtiesIDs = new ArrayList<>();
        Set<CommunityAccount> communites = communityAccountRepository.findAllByAccountId(AccountID.get());
        communites.stream()
                .forEach(communityAccount -> communtiesIDs.add(communityAccount.getCommunity().getId()));
        return loan_postRepository.findAllByCommunity_idInAndVisibleIsTrue(communtiesIDs);
    }

    /**
     * @author Elisabet Aronsson
     * @param loan_post
     * @param communityID
     * Updates the information on a post
     */
    public void updatePost(Loan_Post loan_post, Long communityID) {
        Loan_Post loan_post1 = loan_postRepository.getById(loan_post.getId());
        loan_post1.setStart_date(loan_post.getStart_date());
        loan_post1.setReturn_date(loan_post.getReturn_date());
        loan_post1.setItem(loan_post.getItem());
        loan_postRepository.save(loan_post1);
    }

    /**
     * @author Elisabet Aronsson
     * @param postID
     * @param communityID
     */
    public void deletePost(Long postID, Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            loan_postRepository.deleteById(postID);
        }
    }


    /**
     * @author Hugo Lindstedt
     * @param communityID
     * @return
     */
    public List<LoanPostDTO> communitiesPost(Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            List<LoanPostDTO> posts = new ArrayList<>();
            loan_postRepository.findAllByCommunity_id(communityID).stream()
                    .forEach(loan_post -> {
                        posts.add(new LoanPostDTO(
                                loan_post.getId(),
                                loan_post.getStart_date(),
                                loan_post.getReturn_date(),
                                loan_post.getCommunity().getName(),
                                loan_post.getItem().getName(),
                                loan_post.getAccount().getUsername(),
                                loan_post.getItem().getDescription()
                        ));

                    });
            return posts;
        } else return null;
    }

    /**
     * @author Elisabet Aronsson
     * @param communityID
     * @param postID
     * @return
     */
    public Loan_Post getSpecificPost(Long communityID, Long postID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            return loan_postRepository.getById(postID);
        } else return null;
    }

    /**
     * @author Hugo Lindstedt
     * @param createPostDTO
     */
    public void createPost(CreatePostDTO createPostDTO) {
        Long account_id = AccountID.get();
        CommunityAccount c = communityAccountRepository.findByAccountIdAndCommunityId(account_id,createPostDTO.getCommunity_id()).orElseThrow();

        if (c != null &&
                itemRepository.existsByIdAndAccountId(createPostDTO.getItem_id(), account_id)
                && !loan_postRepository.existsByAccountIdAndItemIdAndVisibleIsTrueAndCommunityId(account_id,createPostDTO.getItem_id(),createPostDTO.getCommunity_id())) {

            Loan_Post post = new Loan_Post();
            Account account = c.getAccount();
            Community community = c.getCommunity();
            Item item = new Item();
            item.setId(createPostDTO.getItem_id());
            post.setStart_date(createPostDTO.getStart_date());
            post.setReturn_date(createPostDTO.getEnd_date());
            post.setItem(item);
            post.setVisible(true);
            post.setAccount(account);
            post.setCommunity(community);
            loan_postRepository.save(post);
        } else {
            System.out.println("You are not a member or this item dont belong to you");
        }
    }

    @GetMapping
    public List<LoanPostDTO> getUserPosts() {
        List<LoanPostDTO> posts = new ArrayList<>();
        loan_postRepository.findAllByAccountId(AccountID.get()).stream()
                .forEach(loan_post -> {
                    posts.add(new LoanPostDTO(
                            loan_post.getId(),
                            loan_post.getStart_date(),
                            loan_post.getReturn_date(),
                            loan_post.getCommunity().getName(),
                            loan_post.getItem().getName(),
                            loan_post.getAccount().getUsername(),
                            loan_post.getItem().getDescription()
                    ));
                });
        return posts;
    }
}
