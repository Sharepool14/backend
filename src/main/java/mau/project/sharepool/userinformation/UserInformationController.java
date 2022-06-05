package mau.project.sharepool.userinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hugo Lindstedt
 * Controller class for UserInformation Objects.
 */
@RestController
@RequestMapping (path = "/user/info")

public class UserInformationController {
    private final UserInformationService service;

    @Autowired
    public UserInformationController(UserInformationService service) {
        this.service = service;
    }

    /**
     * Controller that returns a UserInformation Object.
     * @return
     */
    @GetMapping
    public UserInformation accountBy(){
        return service.accountBy().get().getUserInformation();
    }

    /**
     * Controller that sends a UserInformation object to the service class.
     * @param userInformation
     */
    @PostMapping
    public void editUserInformation(@RequestBody UserInformation userInformation) {
        service.userInformation(userInformation);
    }
}