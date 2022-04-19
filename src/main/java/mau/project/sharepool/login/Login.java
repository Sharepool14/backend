package mau.project.sharepool.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
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
    private String email;
    private Date last_logged_in;
    @JsonProperty("is_active")
    private boolean is_active;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLast_logged_in() {
        return last_logged_in;
    }

    public void setLast_logged_in(Date last_logged_in) {
        this.last_logged_in = last_logged_in;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", last_logged_in=" + last_logged_in +
                ", is_active=" + is_active +
                '}';
    }
}
