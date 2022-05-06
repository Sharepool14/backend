package mau.project.sharepool.community;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping (path = "/user/{account_id}/community")
public class CommunityController {
    private final CommunityService service;

    @Autowired
    public CommunityController(CommunityService service){
        this.service = service;
    }

    @GetMapping(path = "all") // Get = hämtar info
    public List getCommunities(){
        return service.getCommunities();
    }

    @PostMapping(path = "add") // Post = lägga in/ändra
    public ResponseEntity add(@RequestBody Community community){
        service.addToCommunity(community); // Lägger in i DB
        return ResponseEntity.ok(HttpStatus.OK); // Godkännande
    }

    @PostMapping(path = "create"/*, produces = "application/json", consumes = "application/json"*/)
    public void createCommunity(@RequestBody Community newCommunity, @PathVariable("account_id") Long account_id){
        //HttpHeaders responseHeaders = new HttpHeaders();

        if (AccountID.get().equals(String.valueOf(account_id))){
            System.out.println("If-sats");
            switch (service.createCommunity(newCommunity, account_id)){
                //Success
                case 1 -> {
                    //responseHeaders.set("application/json", "Value-accountCreation");
                    //return ResponseEntity.ok(HttpStatus.OK);
                }
                //Wrong format
                case 2 -> {
                    //responseHeaders.set("application/json", "Value-accountCreation");
                    //return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
                }
                default -> {
                    //return null;
                }
            }
        }
        //return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
    /*
    @PostMapping(path = "create")
    public ResponseEntity createCommunity(@RequestBody Community community, AccountID accountID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals(accountID)){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        } else if (!authentication.getName().equals(accountID)){
            service.createCommunity(community);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        service.createCommunity(community);
        return ResponseEntity.ok(HttpStatus.OK);
    }

     */

    @PostMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<Community> accountCommunities(@PathVariable("account_id") String account_id ) {
        if (AccountID.get().equals(account_id)) {
            return service.getAccountCommunties(Long.parseLong(account_id));
        }
        else return null;
    }

    @PostMapping(path = "deleteAll")
    public ResponseEntity deleteAll(){
        service.deleteAllCommunities();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
