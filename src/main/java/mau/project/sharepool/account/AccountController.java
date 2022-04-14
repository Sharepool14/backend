package mau.project.sharepool.account;
import mau.project.sharepool.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}