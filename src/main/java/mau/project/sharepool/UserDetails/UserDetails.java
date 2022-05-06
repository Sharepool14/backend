package mau.project.sharepool.UserDetails;

import mau.project.sharepool.account.Account;
import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_details_id_seq",
            sequenceName = "user_details_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_id_seq"
    )

    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String city;
    private String zipcode;
    private String street;
    @OneToOne(mappedBy = "userDetails")
    private Account account;

    public UserDetails() {
    }

    public UserDetails(String firstname, String lastname, String phone, String city, String zipcode, String street, Account account) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.account = account;
    }

    public UserDetails(int id, String firstname, String lastname, String phone, String city, String zipcode, String street, Account account) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", street='" + street + '\'' +
                ", account=" + account +
                '}';
    }
}