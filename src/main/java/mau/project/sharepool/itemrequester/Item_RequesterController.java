package mau.project.sharepool.itemrequester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user/item_requester")
public class Item_RequesterController {
    private final Item_RequesterService service;

    @Autowired
    public Item_RequesterController(Item_RequesterService service){
        this.service = service;
    }
}
