package mau.project.sharepool.accepted_loan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/user/accepted_loan")

public class Accepted_loanController {
    private final Accepted_loanService accepted_loanService;

    @Autowired
    public Accepted_loanController(Accepted_loanService accepted_loanService){
        this.accepted_loanService = accepted_loanService;
    }
}
