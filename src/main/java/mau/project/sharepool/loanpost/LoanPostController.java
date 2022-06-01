package mau.project.sharepool.loanpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user/loan_post/")
public class LoanPostController {
    private final LoanPostService service;

    @Autowired
    public LoanPostController(LoanPostService service) {
        this.service = service;
    }

    @GetMapping
    public List<LoanPost> all(){
        return service.all();
    }

    @GetMapping(path = "{communityID}/posts")
    public List<LoanPostDTO> communitiesPost(@PathVariable Long communityID){
        return service.communitiesPost(communityID);
    }

    @PostMapping(path = "{communityID}/{postID}")
    public void updatePost(@RequestBody LoanPost loan_post, @PathVariable Long communityID) {
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
    public LoanPost getSpecificPost(@PathVariable Long communityID, @PathVariable Long postID) {
        return service.getSpecificPost(communityID, postID);
    }
}
