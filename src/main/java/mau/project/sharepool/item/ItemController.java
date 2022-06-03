package mau.project.sharepool.item;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

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

    @PostMapping("/item/create")
    public void addItemBy(@RequestBody Item item) {
            itemService.addItemBy(item);
    }

    @PostMapping("items/{item_id}")
    public void changeItem(@RequestBody Item item, Account account, @PathVariable Long account_id, @PathVariable Long item_id){
        if(AccountID.get().equals(account_id)){
            itemService.changeItem(item, item_id);
        }
    }

    @DeleteMapping("items/{item_id}")
    public void deleteItem(){
    }

    @GetMapping
    public Set<Item> getItems() {
        return itemService.itemsBy();
    }
}
