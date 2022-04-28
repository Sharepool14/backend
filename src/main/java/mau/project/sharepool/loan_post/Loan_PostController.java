package mau.project.sharepool.loan_post;

import mau.project.sharepool.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Loan_PostController {

    private final Loan_PostService service;

    @Autowired
    public Loan_PostController(Loan_PostService service) {
        this.service = service;
    }
}
