package mau.project.sharepool.item;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

/**
 * @author Anthon Haväng
 * This class acts as a controller for the Item-package, to allow interaction and management by the Spring REST-API.
 */
@RestController
@RequestMapping(path = "/user/items")
public class ItemController {
    private final ItemService itemService;

    /**
     * @author Anthon Haväng
     * @param service
     */
    @Autowired
    public ItemController(ItemService service){
        this.itemService = service;
    }

    /**
     * @author Elisabet Aronsson
     * @param item
     */
    @PostMapping("/item/create")
    public void addItemBy(@RequestBody Item item) {
            itemService.addItemBy(item);
    }

    /**
     * @author Elisabet Aronsson
     * @param item
     * @param account
     * @param account_id
     * @param item_id
     */
    @PostMapping("items/{item_id}")
    public void changeItem(@RequestBody Item item, Account account, @PathVariable Long account_id, @PathVariable Long item_id){
        if(AccountID.get().equals(account_id)){
            itemService.changeItem(item, item_id);
        }
    }

    @GetMapping
    public Set<Item> getItems() {
        return itemService.itemsBy();
    }
}
