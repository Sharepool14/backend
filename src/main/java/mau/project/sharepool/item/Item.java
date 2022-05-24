package mau.project.sharepool.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.category.Category;
import mau.project.sharepool.loanpost.Loan_Post;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")

/**
 * @author Anthon Haväng
 */
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonIgnore
    private Account account;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<Loan_Post> loan_post;

    /**
     * @author Anthon Haväng
     */
    public Item() {

    }

    /**
     * @author Anthon Haväng
     * @param account
     * @param name
     * @param description
     * @param category
     */
    public Item(Account account, String name, String description, Category category) {
        this.account = account;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    /**
     * @author Anthon Haväng
     * @param id
     * @param account
     * @param name
     * @param description
     * @param category
     */
    public Item(long id, Account account, String name, String description, Category category) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    /**
     * @author Anthon Haväng
     */
    public long getId() {
        return id;
    }

    /**
     * @author Anthon Haväng
     */
    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount_id(Account account) {
        this.account = account;
    }

    /**
     * @author Anthon Haväng
     */
    public String getName() {
        return name;
    }

    /**
     * @author Anthon Haväng
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @author Anthon Haväng
     */
    public String getDescription() {
        return description;
    }

    /**
     * @author Anthon Haväng
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    /**
     * @author Anthon Haväng
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @author Anthon Haväng
     */
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