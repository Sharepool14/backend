package mau.project.sharepool.account;

import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository loginRepo, PasswordEncoder passwordEncoder) {
        this.accountRepository = loginRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Account> single(Long l) {
        return accountRepository.findById(l);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.setAuthorities(authorities);
        return account;
    }

    public int create_account(Account login) {
        try {
            login.setPassword(passwordEncoder.encode(login.getPassword()));
            accountRepository.save(login);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 2;
        }
    }

    public void changeAccount(mau.project.sharepool.userdetails.UserDetails userDetails, Long account_id) {

        if(AccountID.get().equals(String.valueOf(account_id))){
            Account account = accountRepository.getById(account_id);
            userDetails.setId(account.getUserDetails().getId());
            account.setUserDetails(userDetails);
            accountRepository.save(account);
        }
    }
}
