package mau.project.sharepool.account;

import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.loanpost.LoanPost;
import mau.project.sharepool.userinformation.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user/")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService loginService) {
        this.accountService = loginService;
    }

    @GetMapping("account/{id}")
    public Optional<Account> getLogin(@PathVariable("id") Long l) {
        System.out.println(l);
        return accountService.single(l);
    }

    @GetMapping("accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping(value="register")
    public ResponseEntity<String> createAccount(@RequestBody Account login) {
        System.out.println(login.getUserInformation().getFirstname());
        switch (accountService.create_account(login)) {
            case 1 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application-json",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Success.");
            }
            case 2 -> {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("application-json",
                        "Value-accountCreation");
                return ResponseEntity.ok().headers(responseHeaders).body("Something went wrong.");
            }
            default -> {
                return null;
            }
        }
    }
    @GetMapping("{account_id}")
    public Account getAccount(@PathVariable Long account_id){
        if (AccountID.get() == account_id) {
            return accountService.getAccount(account_id);
        } else  return null;
    }

    @PostMapping("{account_id}")
    public void changeAccount(@RequestBody UserInformation userDetails, @PathVariable Long account_id){
        accountService.changeAccount(userDetails, account_id);
    }

    @GetMapping("test")
    public Account test() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return accountService.ad();
    }

    @GetMapping("posts")
    public Set<LoanPost> getYourPosts(){
        return accountService.getYourPosts();
    }

   // @PostMapping("")
    public void editLoanPost(){
        // Man kan kan bara edit om saken inte är i
        // accepted loans och accepted
    }
}
