package mau.project.sharepool.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class AccountController {
    private final AccountService loginService;

    @Autowired
    public AccountController(AccountService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("account/{id}")
    public Optional<Account> getLogin(@PathVariable("id") Long l) {
        System.out.println(l);
        return loginService.single(l);
    }

    @GetMapping("accounts")
    public List<Account> getAll() {
        return loginService.getAll();
    }

    @PostMapping(value="register", produces = "application/json",consumes="application/json")
    public ResponseEntity<String> createAccount(@RequestBody Account login) {
        System.out.println(login.getUserDetails().getFirstname());
        switch (loginService.create_account(login)) {
            case 1 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application/json",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Success.");
            }
            case 2 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application/json",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Something went wrong.");
            }
            default -> {
                return null;
            }
        }
    }
}
