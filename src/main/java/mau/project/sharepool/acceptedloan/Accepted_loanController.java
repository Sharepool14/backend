package mau.project.sharepool.acceptedloan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/user/loan")

public class Accepted_loanController {
    private final Accepted_loanService accepted_loanService;

    @Autowired
    public Accepted_loanController(Accepted_loanService accepted_loanService){
        this.accepted_loanService = accepted_loanService;
    }

    @DeleteMapping("{loan_id}")
    public void rejectLoan(@PathVariable Long loan_id){
        accepted_loanService.rejectLoan(loan_id);
    }

    @PostMapping
    public void acceptLoan(){

    }

    @PostMapping("{postID}/request")
    public void requestLoan(@PathVariable Long postID){
        accepted_loanService.requestLoan(postID);
    }
}
