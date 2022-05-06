package mau.project.sharepool.userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    private UserDetailsRepository accountRepository;

    @Autowired
    public UserDetailsService(UserDetailsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<UserDetails> getAccounts() {
        int i = accountRepository.test(5);
        System.out.println(i);
        return accountRepository.findAll();
    }

    public void addAccount(UserDetails account) {
        accountRepository.save(account);
    }

    public Optional<UserDetails> accountBy(Long account_id){
        return accountRepository.findById(account_id);
    }
}
