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

    private long item_id;
    private String name;
    private Date borrow_date;
    private Date return_date;
    @JsonProperty ("available")
    private boolean available;
    @JsonProperty ("status")
    private boolean status;

    public Item(){

    }

    public Item(
            long item_id,
            String name,
            Date borrow_date,
            Date return_date,
            boolean available,
            boolean status) {

        this.item_id = item_id;
        this.name = name;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.available = available;
        this.status = status;
    }

    public Item(
            String name,
            Date borrow_date,
            Date return_date,
            boolean available,
            boolean status) {

        this.name = name;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.available = available;
        this.status = status;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", borrow_date=" + borrow_date +
                ", return_date=" + return_date +
                ", available=" + available +
                ", status=" + status +
                '}';
    }
}
