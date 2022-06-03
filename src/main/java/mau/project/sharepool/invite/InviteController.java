package mau.project.sharepool.invite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (path = "/user/invite")
public class InviteController {
    private final InviteService service;

    @Autowired
    public InviteController(InviteService service){ this.service = service;}

    @GetMapping(path = "all")
    public void getCommunities(){
    }

    @PostMapping (path = "add")
    public ResponseEntity add(@RequestBody Invite invite){
        service.addInvite(invite);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteAInvite(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public List<InviteDTO> communitiesInvites(){
        return service.getSpecificInvite();
    }

    @PostMapping(path = "{invite_id}")
    public void acceptInvite(@PathVariable Long invite_id) {
        service.handleInvite(invite_id);
    }

    @DeleteMapping(path = "{invite_id}")
    public void deleteInvite(@PathVariable Long invite_id) {
        service.handleInvite(invite_id);
    }
}
