package mau.project.sharepool.itemrequester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user/item_requester")
public class Item_RequesterController {
    private final Item_RequesterService service;

    @Autowired
    public Item_RequesterController(Item_RequesterService service){
        this.service = service;
    }

    @PostMapping(path = "{communityID}/posts/{postID}/request")
    public void requestAPost(@RequestBody Item_Requester item_requester, @PathVariable Long communityID, @PathVariable Long postID){
        service.requestAPost(item_requester, communityID);
    }

    @GetMapping(path = "test")
    public List<Item_Requester> getAll(){
        return service.getAll();
    }
}
