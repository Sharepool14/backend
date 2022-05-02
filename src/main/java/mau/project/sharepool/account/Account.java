package mau.project.sharepool.account;

import mau.project.sharepool.address.Address;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String phone;

    public Account() {
    }

    public Account(String firstname, String lastname, Address address, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }

    public Account(int id, String firstname, String lastname, Address address, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address{" + address.toString() +
                        "} , phone='" + phone + '\'' +
                        '}';
        }
    }
