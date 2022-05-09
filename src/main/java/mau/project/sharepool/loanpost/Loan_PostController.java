package mau.project.sharepool.loanpost;

import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.userinformation.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user/loan_post")
public class Loan_PostController {
    private final Loan_PostService service;

    @Autowired
    public Loan_PostController(Loan_PostService service) {
        this.service = service;
    }

    @GetMapping(path = "test")
    public List<Loan_Post> all() {
        return service.all();
    }

    @GetMapping(path = "{communityID}/posts")
    public List<Loan_Post> communitiesPost(@PathVariable Long communityID) {
        return service.communitiesPost(communityID);
    }

    @PostMapping(path = "{communityID}/{postID}")
    public void updatePost(@RequestBody Loan_Post loan_post) {
        service.updatePost(loan_post);
    }

    @DeleteMapping(path = "{communityID}/{postID}")
    public void deletePost(@PathVariable Long postID) {
        service.deletePost(postID);
    }


    @GetMapping("{communityID}/posts/{postID}")
    public Loan_Post getSpecificPost(@PathVariable Long communityID, @PathVariable Long postID) {
        return service.getSpecificPost(communityID, postID);
    }

    @PostMapping(path = "communities/{communityID}/post/create")
    public void createPost(@RequestBody Loan_Post loan_post, @PathVariable Long communityID){
        service.createPost(loan_post, communityID);
    }
}

