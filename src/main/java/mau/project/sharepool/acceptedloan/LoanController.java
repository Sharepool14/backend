package mau.project.sharepool.acceptedloan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/user/loan")

public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService accepted_loanService){
        this.loanService = accepted_loanService;
    }

    @PostMapping("{postID}/request")
    public void requestLoan(@PathVariable Long postID){
        loanService.requestLoan(postID);
    }
}
