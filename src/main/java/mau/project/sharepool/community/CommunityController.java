package mau.project.sharepool.community;

import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "all")
    public List getCommunities(){
        return service.getCommunities();
    }

    @PostMapping(path = "add")
    public ResponseEntity add(@RequestBody Community community){
        service.addToCommunity(community);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * @auth Anthon Haväng
     * @param newCommunity
     * @param account_id
     * @return returns a HttpStatus for front-end.
     * HttpHeaders is left behind unused to remain as a template for further use.
     */
    @PostMapping(path = "create")
    public ResponseEntity<HttpStatus> createCommunity(@RequestBody Community newCommunity, @PathVariable("account_id") Long account_id){
        HttpHeaders responseHeaders = new HttpHeaders();

        if (AccountID.get().equals(account_id)){
            System.out.println("If-sats");
            switch (service.createCommunity(newCommunity, account_id)){
                //Success
                case 1 -> {
                    responseHeaders.set("application/json", "Value-accountCreation");
                    return ResponseEntity.ok(HttpStatus.OK);
                }
                //Wrong format
                case 2 -> {
                    responseHeaders.set("application/json", "Value-accountCreation");
                    return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
                }
                default -> {
                    return null;
                }
            }
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<Community> accountCommunities(@PathVariable("account_id") Long account_id ) {
        if (account_id.equals(AccountID.get())) {
            return service.getAccountCommunities(account_id);
        }
        else return null;
    }

    @PostMapping(path = "deleteAll")
    public ResponseEntity deleteAll(){
        service.deleteAllCommunities();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
