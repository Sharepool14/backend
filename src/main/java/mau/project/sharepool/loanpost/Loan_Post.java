package mau.project.sharepool.loanpost;


import com.fasterxml.jackson.annotation.JsonIgnore;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.community.Community;
import mau.project.sharepool.item.Item;
//import mau.project.sharepool.itemrequester.Item_Requester;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "loan_post")
public class Loan_Post {
    @Id
    @SequenceGenerator(
            name = "loan_post_id_seq",
            sequenceName = "loan_post_id_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "loan_post_id_seq"
    )
    private long id;
    private Date start_date;
    private Date return_date;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Community community;

    /*@JsonIgnore
    @OneToMany(mappedBy = "loan_post")
    private Set<Item_Requester> item_requester;*/

    @ManyToOne
    private Account account;
    private boolean visible;

    public Loan_Post() {
    }

    public Loan_Post(Date start_date, Date return_date, Item item, Community community, boolean visible) {
        this.start_date = start_date;
        this.return_date = return_date;
        this.item = item;
        this.community = community;
        this.visible = visible;
    }

    public Loan_Post(long id, Date start_date, Date return_date, Item item, Community community, boolean visible) {
        this.id = id;
        this.start_date = start_date;
        this.return_date = return_date;
        this.item = item;
        this.community = community;
        this.visible = visible;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Loan_Post{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", return_date=" + return_date +
                ", item=" + item +
                ", community=" + community +
                ", account=" + account +
                ", visible=" + visible +
                '}';
    }
}