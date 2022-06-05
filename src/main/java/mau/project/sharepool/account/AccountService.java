package mau.project.sharepool.account;

import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.ItemRepository;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.userinformation.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Hugo Lindstedt
 */

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final CommunityAccountRepository communityAccountRepository;
    private ItemRepository itemRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountService(
              ItemRepository itemRepository,
              AccountRepository loginRepo,
              PasswordEncoder passwordEncoder,
              CommunityAccountRepository communityAccountRepository) {

        this.communityAccountRepository = communityAccountRepository;
        this.itemRepository = itemRepository;
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
        Set<CommunityAccount> mebership = communityAccountRepository.findAllByAccountId(account.getId());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        mebership.stream()
                        .forEach(communityAccount ->authorities.add(new SimpleGrantedAuthority(String.valueOf(communityAccount.getCommunity().getId()))) );
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

    public void changeAccount(UserInformation userDetails, Long account_id) {
        if(AccountID.get() == account_id){
            Account account = accountRepository.getById(account_id);
            userDetails.setId(account.getUserInformation().getId());
            account.setUserInformation(userDetails);
            accountRepository.save(account);
        }
    }

    public Account getAccount(Long account_id) {
        return accountRepository.getById(account_id);
    }

    public Set<Loan_Post> getYourPosts() {
        return accountRepository.getById(AccountID.get()).getLoanPosts();
    }
}
