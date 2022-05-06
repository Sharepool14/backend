package mau.project.sharepool.item;

import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping(path = "/user/{account_id}")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService service){
        this.itemService = service;
    }

    @PostMapping(path = "add")
    public void addItem(Item item){
        itemService.addItem(item);
    }

    @PostMapping("/item/create")
    public void addItemBy(@RequestBody Item item, @PathVariable Long account_id) {
        if (AccountID.get().equals(account_id)) {
            itemService.addItemBy(item, account_id);
        }
    }

    @PostMapping("items/{item_id}")
    public void changeItem(){

    }

    @DeleteMapping("items/{item_id}")
    public void deleteItem(){

    }

    @GetMapping("items")
    public Set<Item> getItems(@PathVariable("account_id") long account_id) {
        if (AccountID.get().equals(String.valueOf(account_id))){
            return itemService.itemsBy(account_id);
        } else return null;
    }
}
