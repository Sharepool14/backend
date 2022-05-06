package mau.project.sharepool.item;

import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item){
        itemRepository.save(item);
    }

    public Set<Item> itemsBy(long account_id) {
        if(AccountID.get().equals(String.valueOf(account_id))){
            return itemRepository.findAllByAccountId(account_id);
        } else {
           return null;
        }
    }
}
