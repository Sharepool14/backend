package mau.project.sharepool.login;

import mau.project.sharepool.account.Account;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @SequenceGenerator(
            name = "login_id_seq",
            sequenceName = "login_id_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_id_seq"
    )
    private Long id;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Login() {
    }

    public Login(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public Login(Long id, String username, String password, Account account) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }
}