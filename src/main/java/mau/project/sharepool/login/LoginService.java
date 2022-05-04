package mau.project.sharepool.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {
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

    public int create_account(Login login) {
        try {
            login.setPassword(passwordEncoder.encode(login.getPassword()));
            loginRepo.save(login);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 2;
        }
    }
}
