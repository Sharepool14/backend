package mau.project.sharepool.acceptedloan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/user/loan")

public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService accepted_loanService){
        this.loanService = accepted_loanService;
    }

    @DeleteMapping("{loan_id}")
    public void rejectLoan(@PathVariable Long loan_id){
        loanService.rejectLoan(loan_id);
    }

    @PostMapping("{loan_id}")
    public void acceptLoan(@PathVariable Long loan_id){
        loanService.acceptLoan(loan_id);
    }

    @PostMapping("{postID}/request")
    public void requestLoan(@PathVariable Long postID){
        loanService.requestLoan(postID);
    }

    @DeleteMapping("your/{loan_id}")
    public void deleteYourReq(@PathVariable Long loan_id){
        loanService.deleteYourReq(loan_id);
    }

   /* @PostMapping("{loan_id}/return")
    public void returnLoan(@PathVariable Long loan_id){
        loanService.returnLoan(loan_id);
    } */
}
