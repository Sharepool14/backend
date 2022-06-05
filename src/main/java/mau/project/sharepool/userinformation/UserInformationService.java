package mau.project.sharepool.userinformation;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.account.AccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Hugo Lindstedt
 * Class that performs logic on UserInformation objects and saves them to the database.
 */
@Service
public class UserInformationService {
    private UserInformationRepository userInformationRepository;
    private AccountRepository accountRepository;

    @Autowired
    public UserInformationService(UserInformationRepository userInformationRepository, AccountRepository accountRepository) {
        this.userInformationRepository = userInformationRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Returns a list of all UserInformation objects
     * @return
     */
    public List<UserInformation> getAccounts() {
        return userInformationRepository.findAll();
    }

    /**
     * Saves a new UserInformation Object.
     * @param userInformation
     */
    public void userInformation(UserInformation userInformation) {
        userInformation.setId(AccountID.get());
        userInformationRepository.save(userInformation);
    }

    /**
     * Tries to find an UserInformation object by its primary key id.
     * @return
     */
    public Optional<Account> accountBy(){
        return accountRepository.findById(AccountID.get());
    }
}
