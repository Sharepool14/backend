package mau.project.sharepool.community;

import com.fasterxml.jackson.annotation.JsonView;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.loanpost.Loan_Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import mau.project.sharepool.account.Views;

/**
 * @author Anthon Haväng
 * Controller class for CommunityController collection table.
 */
@RestController
public class CommunityController {
    private final CommunityService service;

    /**
     * @author Elisabet Aronsson
     * @param service
     */
    @Autowired
    public CommunityController(CommunityService service){
        this.service = service;
    }

    /**
     * @author Elisabet Aronsson
     * @return
     */
    @GetMapping(path = "all")
    public List getCommunities(){
        return service.getCommunities();
    }

    /**
     * @author Anthon Haväng
     * This method returns all the members of a specific community from the database.
     * @param community_id Provided from front-end, used to specify which community to fetch from in the database.
     * @return Returns all members of the specified community.
     */
    @GetMapping(path = "communities/{communityID}/members")
    @JsonView(Views.response.class)
    public Set<Account> getMembersInCommunity(@PathVariable("communityID") Long community_id){
        return service.getMembersInCommunity(community_id);
    }

    /**
     * @author Anthon Haväng, Hugo Lindstedt
     * This method is used to create a new community and add it to the database. The switch-case is used to deliver
     * status codes for front-end depending on if the creation was successful or failed.
     * @param newCommunity
     * @return returns a HttpStatus for front-end with HTTP-status code for fail and success.
     */
    @PostMapping(path = "/user/community/create")
    public ResponseEntity<HttpStatus> createCommunity(@RequestBody Community newCommunity) {
        HttpHeaders responseHeaders = new HttpHeaders();
        switch (service.createCommunity(newCommunity)) {
            case 1 -> {
                responseHeaders.set("application/json", "Value-accountCreation");
                return ResponseEntity.ok(HttpStatus.OK);
            }

            case 2 -> {
                responseHeaders.set("application/json", "Value-accountCreation");
                return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            }

            default -> {
                return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            }
        }
    }

    /**
     * @author Elisabet Aronsson
     * @param id
     * @return
     */
    @DeleteMapping(path = "/user/{account_id}/community/delete")
    public ResponseEntity deleteYourCommunity(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/user/community")
    public Set<Community> getUsersCommunities() {
        return service.getAccountCommunities();
    }

    /**
     * @author Elisabet Aronsson
     * @param community_id
     * @return
     */
    @GetMapping("{community_id}")
    public Community getCommunity(@PathVariable Long community_id){
        return service.getACommunity(community_id);
    }

    @PostMapping("communities/{community_id}/members/invite/{username}")
    public void invite(@PathVariable Long community_id, @PathVariable String username) {
        service.createInvite(community_id,username);
    }

    /**
     * @author Anthon Haväng, Elisabet Aronsson
     * This method returns all the posts from a specific community from the community-table in the databse.
     * @param community_id Provided from front-end, used to specify which community to fetch from in the database.
     * @return Returns a Set with all the posts from the specified community.
     */
    @GetMapping("community/{community_id}/posts")
    public Set<Loan_Post> getThisCommunitysPosts(@PathVariable Long community_id){
        return service.getThisCommunitysPosts(community_id);
    }

    /**
     * @author Anthon Haväng
     * This method is used when a user wants to leave a community.
     * @param community_id Provided from front-end, used to specify which community the user is to be removed from.
     */
    @PostMapping("/user/communtiy/{community_id}/leave")
    public void leaveCommunity(@PathVariable Long community_id){
        service.leaveCommunity(community_id);
    }
}
