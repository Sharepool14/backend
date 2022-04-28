package mau.project.sharepool.login;

import mau.project.sharepool.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {
    @PersistenceContext
    private EntityManager entityManager;

    private final LoginRepository loginRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(LoginRepository loginRepo, PasswordEncoder passwordEncoder) {
        this.loginRepo = loginRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Login> single(Long l) {
        return loginRepo.findById(l);
    }

    public List<Login> getAll() {
        return loginRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepo.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(login.getUsername(),login.getPassword(),authorities);
    }

    public void create_account(Login login, Account account) {
        Login checkLogin = loginRepo.findByUsername(login.getUsername());

        if (checkLogin == null) {
            entityManager.persist(login);
            entityManager.persist(account);
            entityManager.flush();
        }
    }
}
