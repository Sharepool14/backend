package mau.project.sharepool.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
    private final AccountRepository loginRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(AccountRepository loginRepo, PasswordEncoder passwordEncoder) {
        this.loginRepo = loginRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Account> single(Long l) {
        return loginRepo.findById(l);
    }

    public List<Account> getAll() {
        return loginRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account login = loginRepo.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        login.setAuthorities(authorities);
        return login;
    }

    public int create_account(Account login) {
        try {
            login.setPassword(passwordEncoder.encode(login.getPassword()));
            loginRepo.save(login);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 2;
        }
    }
}
