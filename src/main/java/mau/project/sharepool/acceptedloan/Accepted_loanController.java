package mau.project.sharepool.acceptedloan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/user/loan")

public class Accepted_loanController {
    private final Accepted_loanService accepted_loanService;

    @Autowired
    public Accepted_loanController(Accepted_loanService accepted_loanService){
        this.accepted_loanService = accepted_loanService;
    }

    @PostMapping("{postID}/request")
    public void requestLoan(@PathVariable Long postID){
        accepted_loanService.requestLoan(postID);
    }
}
