package mau.project.sharepool.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<Login2> getLogin(@PathVariable("id") Long l) {
        System.out.println(l);
        return loginService.single(l);
    }

    @GetMapping("accounts")
    public List<Login2> getAll() {
        return loginService.getAll();
    }
}
