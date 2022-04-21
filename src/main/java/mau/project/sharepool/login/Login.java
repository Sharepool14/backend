package mau.project.sharepool.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @SequenceGenerator(
            name = "login2_id_seq",
            sequenceName = "login2_id_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login2_id_seq"
    )
    private Long id;
    private String username;
    private String password;
    private String account_id;

    public Login() {
    }

    public Login(String username, String password, String account_id) {
        this.username = username;
        this.password = password;
        this.account_id = account_id;
    }

    public Login(Long id, String username, String password, String account_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account_id = account_id;
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

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account_id='" + account_id + '\'' +
                '}';
    }
}