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

    /**
     * @author Anthon Haväng
     * Constructor for this class.
     */
    @Autowired
    public ItemService(ItemRepository itemRepository, AccountRepository accountRepository){
        this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;
    }

    public Set<Item> itemsBy() {
        return itemRepository.findAllByAccountId(AccountID.get());
    }

    public void addItemBy(Item item) {
        Account account = accountRepository.getById(AccountID.get());
        item.setAccount(accountRepository.getById(AccountID.get()));
        account.getItems().add(item);
        accountRepository.save(account);
    }

    public void changeItem(Item item, Long item_id) {
        Item item1 = itemRepository.getById(item_id);
        item1.setName(item.getName());
        item1.setDescription(item.getDescription());
        item1.setCategory(item.getCategory());
        itemRepository.save(item1);
    }
}
