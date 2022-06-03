package mau.project.sharepool.loanpost;

import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.userinformation.UserInformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user/loan_post/")
public class Loan_PostController {
    private final Loan_PostService service;

    @Autowired
    public Loan_PostController(Loan_PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<LoanPostDTO> all(){
        return service.getUserPosts();
    }

    @GetMapping(path = "{communityID}/posts")
    public List<LoanPostDTO> communitiesPost(@PathVariable Long communityID){
        return service.communitiesPost(communityID);
    }

    @PostMapping(path = "{communityID}/{postID}")
    public void updatePost(@RequestBody Loan_Post loan_post, @PathVariable Long communityID) {
        service.updatePost(loan_post, communityID);
    }

    @DeleteMapping(path = "{communityID}/{postID}")
    public void deletePost(@PathVariable Long postID, @PathVariable Long communityID) {
        service.deletePost(postID, communityID);
    }

    @PostMapping(path = "communities/{communityID}/post/create")
    public void createPost(@RequestBody CreatePostDTO createPostDTO){
        service.createPost(createPostDTO);
    }

    @GetMapping("{communityID}/posts/{postID}")
    public Loan_Post getSpecificPost(@PathVariable Long communityID, @PathVariable Long postID) {
        return service.getSpecificPost(communityID, postID);
    }
}
