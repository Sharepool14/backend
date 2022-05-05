package mau.project.sharepool.community_account;

import mau.project.sharepool.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path = "user/{account_id}/")
public class Community_AccountController {
     private final Community_AccountService service;

     @Autowired
     public Community_AccountController(Community_AccountService service){
          this.service = service;
     }

     /*
     @GetMapping(path = "community" )
     public List<Community> listUsersCommunities(@PathVariable("account_id") String account_id){
          return service.listUsersCommunities(account_id);
     }
     */
}
