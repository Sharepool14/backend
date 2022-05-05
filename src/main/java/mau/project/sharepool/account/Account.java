package mau.project.sharepool.account;

import mau.project.sharepool.UserDetails.UserDetails;
import mau.project.sharepool.community.Community;
import mau.project.sharepool.communityaccount.CommunityAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @SequenceGenerator(
            name = "account_id_seq",
            sequenceName = "account_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id_seq"
    )

    private Long id;
    private String username;
    private String password;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private UserDetails userDetails;
    @OneToMany(mappedBy = "account")
    Set<CommunityAccount> communityAccounts;

    @Transient
    private Collection<SimpleGrantedAuthority> authorities;


    public Account() {
    }

    public Account(String username, String password, Collection<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Account(String username, String password, UserDetails userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    public Account(Long id, String username, String password, UserDetails userDetails) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}