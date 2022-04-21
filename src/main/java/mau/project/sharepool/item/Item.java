package mau.project.sharepool.item;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private int account_id;
    private String name;
    private String description;
    private int category_id;

    public Item() {

    }

    public Item(int account_id, String name, String description, int category_id) {
        this.account_id = account_id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
    }

    public Item(long id, int account_id, String name, String description, int category_id) {
        this.id = id;
        this.account_id = account_id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}