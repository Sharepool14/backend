package mau.project.sharepool.community;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @PostMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<Community> accountCommunties(@PathVariable("account_id") String account_id ) {
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
