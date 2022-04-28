package mau.project.sharepool.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (path = "/api/account")
public class AccountController {
    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(path = "all") // Get = hämtar info

    public List getAccounts() {
        return service.getAccounts();
    }

    @PostMapping(path = "signup")
    public void addAccount(@RequestBody Account account) {
        System.out.println("sign up!");
        service.addAccount(account);
    }
}