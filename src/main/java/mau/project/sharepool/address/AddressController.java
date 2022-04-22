package mau.project.sharepool.address;

import mau.project.sharepool.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/address")
public class AddressController {
    private final AddressService service;

    @Autowired

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping(path = "all") // Get = hämtar info
    public List getAccounts() {
        return service.getAddress();
    }

}
