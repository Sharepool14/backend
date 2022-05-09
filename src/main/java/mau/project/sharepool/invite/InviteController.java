package mau.project.sharepool.invite;

import com.fasterxml.jackson.annotation.JsonView;
import mau.project.sharepool.account.Views;
import mau.project.sharepool.community.CommunityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping (path = "/user/invite")
public class InviteController {
    private final InviteService service;

    @Autowired
    public InviteController(InviteService service){ this.service = service;}

    @GetMapping(path = "all")
    public List getCommunities(){ return service.getInvites();}

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




}
