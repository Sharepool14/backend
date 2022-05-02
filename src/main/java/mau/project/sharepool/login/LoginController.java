package mau.project.sharepool.login;

import mau.project.sharepool.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("account/{id}")
    public Optional<Login> getLogin(@PathVariable("id") Long l) {
        System.out.println(l);
        return loginService.single(l);
    }

    @GetMapping("accounts")
    public List<Login> getAll() {
        return loginService.getAll();
    }

    @PostMapping("create_account")
    public void createAccount(Login login){
        loginService.create_account(login);
    }
}
