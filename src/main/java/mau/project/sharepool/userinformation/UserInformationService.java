package mau.project.sharepool.userinformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserInformationService {
    private UserInformationRepository accountRepository;

    @Autowired
    public UserInformationService(UserInformationRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<UserInformation> getAccounts() {
        int i = accountRepository.test(5);
        System.out.println(i);
        return accountRepository.findAll();
    }

    public void addAccount(UserInformation account) {
        accountRepository.save(account);
    }

    public Optional<UserInformation> accountBy(Long account_id){
        return accountRepository.findById(account_id);
    }
}
