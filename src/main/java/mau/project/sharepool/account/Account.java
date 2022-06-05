package mau.project.sharepool.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import mau.project.sharepool.acceptedloan.Loan;
import mau.project.sharepool.invite.Invite;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.userinformation.UserInformation;
import mau.project.sharepool.communityaccount.CommunityAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(Views.response.class)
    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private UserInformation userInformation;

    @OneToMany(mappedBy = "account") @JsonIgnore
    Set<CommunityAccount> communityAccounts;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL) @JsonIgnore
    Set<Item> items;

    @OneToMany(mappedBy = "account")
    Set<Loan_Post> loanPosts;

    @OneToMany(mappedBy = "account")
    Set<Loan> loans;

    @JsonIgnore
    @Transient
    private Collection<SimpleGrantedAuthority> authorities;

    @OneToMany(mappedBy = "inviter")
    private List<Invite> inviter;

    @OneToMany(mappedBy = "invited")
    private List<Invite> invited;

    public Account() {
    }

    public Account(String username, String password, Collection<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Account(String username, String password, UserInformation userInformation) {
        this.username = username;
        this.password = password;
        this.userInformation = userInformation;
        //this.items = items;
    }

    public Account(Long id, String username, String password, UserInformation userInformation, Set<Item> items) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userInformation = userInformation;
        this.items = items;
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

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userDetails) {
        this.userInformation = userDetails;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Loan_Post> getLoanPosts() {
        return loanPosts;
    }

    public void setLoanPosts(Set<Loan_Post> loanPosts) {
        this.loanPosts = loanPosts;
    }

    public Set<CommunityAccount> getCommunityAccounts() {
        return communityAccounts;
    }

    public void setCommunityAccounts(Set<CommunityAccount> communityAccounts) {
        this.communityAccounts = communityAccounts;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public List<Invite> getInviter() {
        return inviter;
    }

    public void setInviter(List<Invite> inviter) {
        this.inviter = inviter;
    }

    public List<Invite> getInvited() {
        return invited;
    }

    public void setInvited(List<Invite> invited) {
        this.invited = invited;
    }

    /**
     * @author Anthon Haväng
     */
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + userInformation +
                ", items=" + items +
                '}';
    }
}