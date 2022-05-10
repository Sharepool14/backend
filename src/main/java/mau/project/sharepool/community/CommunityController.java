package mau.project.sharepool.community;

import com.fasterxml.jackson.annotation.JsonView;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import mau.project.sharepool.account.Views;

@RestController
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

    @GetMapping(path = "communities/{communityID}/members")
    @JsonView(Views.response.class)
    public Set<Account> getMembersInCommunity(@PathVariable("communityID") Long community_id){
        return service.getMembersInCommunity(community_id);
    }

    /**
     * @auth Anthon Haväng
     * @param newCommunity
     * @param account_id
     * @return returns a HttpStatus for front-end.
     * HttpHeaders is left behind unused to remain as a template for further use.
     */
    @PostMapping(path = "/user/{account_id}/community/create")
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

    @PostMapping(path = "/user/{account_id}/community/delete")
    public ResponseEntity deleteYourCommunity(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/user/community")
    public Set<Community> getUsersCommunities() {
        return service.getAccountCommunities();
    }

    @GetMapping("{community_id}")
    public Community getCommunity(@PathVariable Long community_id){
        return service.getACommunity(community_id);
    }
}
