package mau.project.sharepool.userinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/user/info")

public class UserInformationController {
    private final UserInformationService service;

    @Autowired
    public UserInformationController(UserInformationService service) {
        this.service = service;
    }

    @GetMapping
    public UserInformation accountBy(){
        return service.accountBy().get().getUserInformation();
    }
}