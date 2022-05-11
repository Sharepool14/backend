package mau.project.sharepool.userinformation;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserInformationService {
    private UserInformationRepository userInformationRepository;
    private AccountRepository accountRepository;

    @Autowired
    public UserInformationService(UserInformationRepository userInformationRepository, AccountRepository accountRepository) {
        this.userInformationRepository = userInformationRepository;
        this.accountRepository = accountRepository;
    }

    public List<UserInformation> getAccounts() {
        return userInformationRepository.findAll();
    }

    public void addAccount(UserInformation account) {
        userInformationRepository.save(account);
    }

    public Optional<Account> accountBy(){
        return accountRepository.findById(AccountID.get());
    }
}
