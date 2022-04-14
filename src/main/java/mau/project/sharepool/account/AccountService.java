package mau.project.sharepool.account;
import mau.project.sharepool.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
