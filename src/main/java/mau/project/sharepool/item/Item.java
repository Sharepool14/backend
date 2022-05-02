package mau.project.sharepool.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.category.Category;
import org.hibernate.boot.archive.scan.spi.ClassDescriptor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "item")

public class Item {

    @Id
    @SequenceGenerator(
            name = "item_id_seq",
            sequenceName = "item_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_seq"
    )

    private long id;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Item() {

    }

    public Item(Account account, String name, String description, Category category) {
        this.account = account;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Item(long id, Account account, String name, String description, Category category) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount_id(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", account{" +  account.toString() +
                "}, name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category{" + category.toString() + "}" +
                '}';
    }
}