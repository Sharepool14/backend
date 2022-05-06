package mau.project.sharepool.loanpost;

import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.userinformation.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Loan_PostController {
    private final Loan_PostService service;

    @Autowired
    public Loan_PostController(Loan_PostService service) {
        this.service = service;
    }

    @GetMapping(path = "test")
    public List<Loan_Post> all(){
        return service.all();
    }

    @PostMapping(path = "{communityID}/{postID}")
    public void updatePost(@RequestBody Loan_Post loan_post) {
        service.updatePost(loan_post);
    }

    @DeleteMapping(path = "{communityID}/{postID}")
    public void deletePost(@PathVariable Long postID) {
        service.deletePost(postID);
    }
}
