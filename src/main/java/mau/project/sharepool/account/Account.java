package mau.project.sharepool.account;

import mau.project.sharepool.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import mau.project.sharepool.community_account.Community_Account;
import mau.project.sharepool.login.Login;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_id_seq",
            sequenceName = "account_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id_seq"
    )

    private int id;
    private String firstname;
    private String lastname;
    @OneToMany
    @JoinColumns({
              @JoinColumn(name = "community_account_accountId", referencedColumnName = "accountId"),
              @JoinColumn(name = "community_account_communityId", referencedColumnName = "communityId")
    })
    private List<Community_Account> community_account;
    //@JoinColumn(name = "address_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String phone;
    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private Login login;

    public Account() {
    }

    public Account(String firstname,
                   String lastname,
                   List<Community_Account> community_account,
                   Address address,
                   String phone,
                   Login login) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.community_account = community_account;
        this.address = address;
        this.phone = phone;
        this.login = login;
    }

    public Account(int id,
                   String firstname,
                   String lastname,
                   List<Community_Account> community_account,
                   Address address,
                   String phone,
                   Login login) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.community_account = community_account;
        this.address = address;
        this.phone = phone;
        this.login = login;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }


    public List<Community_Account> getCommunity_account() {
        return community_account;
    }

    public void setCommunity_account(List<Community_Account> community_account) {
        this.community_account = community_account;
    }

    @Override
    public String toString() {
        return "Account{" +
                  "id=" + id +
                  ", firstname='" + firstname + '\'' +
                  ", lastname='" + lastname + '\'' +
                  ", community_account=" + community_account +
                  ", address=" + address +
                  ", phone='" + phone + '\'' +
                  ", login=" + login +
                  '}';
    }
}