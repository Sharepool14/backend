package mau.project.sharepool.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @SequenceGenerator(
            name = "community_id_seq",
            sequenceName = "community_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "community_id_seq"
    )

    private int account_id;
    private String first_name;
    private String last_name;
    private int score;
    private String city;
    private int zip_code;
    private String address;
    private String phone_number;
    private Date date_joined;
    private String profile_picture;

    public Account() {
    }

    public Account(String first_name, String last_name, int score, String city, int zip_code, String address, String phone_number, Date date_joined, String profile_picture) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.score = score;
        this.city = city;
        this.zip_code = zip_code;
        this.address = address;
        this.phone_number = phone_number;
        this.date_joined = date_joined;
        this.profile_picture = profile_picture;
    }

    public Account(int account_id, String first_name, String last_name, int score, String city, int zip_code, String address, String phone_number, Date date_joined, String profile_picture) {
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.score = score;
        this.city = city;
        this.zip_code = zip_code;
        this.address = address;
        this.phone_number = phone_number;
        this.date_joined = date_joined;
        this.profile_picture = profile_picture;
    }
}
