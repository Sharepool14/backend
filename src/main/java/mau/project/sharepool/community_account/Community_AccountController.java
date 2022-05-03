package mau.project.sharepool.community_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path = "user/{id}/community")
public class Community_AccountController {
     private final Community_AccountService service;

     @Autowired
     public Community_AccountController(Community_AccountService service){
          this.service = service;
     }

     @GetMapping(path = "user/{id}/community" )
     public List listUsersCommunities(){
          return service.listUsersCommunities();
     }
}
