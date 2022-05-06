package mau.project.sharepool.item;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, AccountRepository accountRepository){
        this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;
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

    public void newItemBy(Item item, Long account_id) {
        itemRepository.save(item);
    }

    public void addItemBy(Item item, Long account_id) {
        Account account = accountRepository.getById(account_id);
        account.getItems().add(item);
        accountRepository.save(account);
    }
}
