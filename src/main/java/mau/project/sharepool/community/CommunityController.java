package mau.project.sharepool.community;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "all") // Get = hämtar info
    public List getCommunities(){
        return service.getCommunities();
    }

    @PostMapping(path = "add") // Post = lägga in/ändra
    public ResponseEntity add(@RequestBody Community community){
        service.addToCommunity(community); // Lägger in i DB
        //System.out.println(community.getVisible());
        return ResponseEntity.ok(HttpStatus.OK); // Godkännande
    }

    @PostMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteACommunity(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<Community> accountCommunties() {
        return service.getAccountCommunties(19L);
    }



    @PostMapping(path = "deleteAll")
    public ResponseEntity deleteAll(){
        service.deleteAllCommunities();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
