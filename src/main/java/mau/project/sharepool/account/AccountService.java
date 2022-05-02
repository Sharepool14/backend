package mau.project.sharepool.account;
import mau.project.sharepool.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        int i = accountRepository.test(5);
        System.out.println(i);

        return accountRepository.findAll();
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public Optional<Account> accountBy(Long account_id){
        return accountRepository.findById(account_id);
    }
}
