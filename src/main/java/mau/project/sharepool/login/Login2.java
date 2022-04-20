package mau.project.sharepool.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "login2")
public class Login2 {
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
    private Date last_logged_in;
    @JsonProperty("is_active")
    private boolean is_active;

    public Login2() {
    }

    public Login2(String username, String password, Date last_logged_in, boolean is_active) {
        this.username = username;
        this.password = password;
        this.last_logged_in = last_logged_in;
        this.is_active = is_active;
    }

    public Login2(Long id, String username, String password, Date last_logged_in, boolean is_active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.last_logged_in = last_logged_in;
        this.is_active = is_active;
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
        return "Login2{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_logged_in=" + last_logged_in +
                ", is_active=" + is_active +
                '}';
    }
}
