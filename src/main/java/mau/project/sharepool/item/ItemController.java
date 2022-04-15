package mau.project.sharepool.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
