package mau.project.sharepool.account;

import mau.project.sharepool.UserDetails.UserDetails;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
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

    public Account() {
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