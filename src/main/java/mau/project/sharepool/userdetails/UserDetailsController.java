package mau.project.sharepool.userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping (path = "/api/account")
public class UserDetailsController {
    private final UserDetailsService service;

    @Autowired
    public UserDetailsController(UserDetailsService service) {
        this.service = service;
    }

    @GetMapping(path = "all") // Get = hämtar info
    public List getAccounts() {
        return service.getAccounts();
    }

    @PostMapping(path = "signup")
    public void addAccount(@RequestBody UserDetails account) {
        System.out.println("sign up!");
        service.addAccount(account);
    }

    @GetMapping("{account_id}")
    public Optional<UserDetails> accountBy(@PathVariable("account_id") Long account_id){
        return service.accountBy(account_id);
    }
}