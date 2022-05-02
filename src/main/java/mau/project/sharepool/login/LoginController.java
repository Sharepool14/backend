package mau.project.sharepool.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createAccount(@RequestBody Login login) {
        switch (loginService.create_account(login)) {
            case 1 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application-JSON",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Success.");
            }
            case 2 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application-JSON",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Something went wrong.");
            }
            default -> {
                return null;
            }
        }
    }
}
