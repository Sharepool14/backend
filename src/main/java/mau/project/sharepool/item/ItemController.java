package mau.project.sharepool.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/item")
public class ItemController {
    private final ItemService service;

    @Autowired
    public ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping(path = "get")
    public List<Item> getItems() {
        return service.getItems();
    }

    @PostMapping(path = "add")
    public void addItem(Item item){
        service.addItem(item);
    }

    @GetMapping("{account_id}")
    public Optional<Item> itemsBy(@PathVariable("account_id") Long account_id) {
        System.out.println(account_id);
        return service.itemsBy(account_id);
    }
}
