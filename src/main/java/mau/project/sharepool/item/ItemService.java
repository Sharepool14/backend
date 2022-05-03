package mau.project.sharepool.item;

import mau.project.sharepool.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> itemsBy(String account_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getName().equals(account_id)){
            System.out.println("You are " + account_id);
        } else {
            System.out.println("You failed!");
        }
        return //itemRepository.findById(account_id);
        itemRepository.findAll();
    }
}
