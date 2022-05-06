package mau.project.sharepool.itemrequester;

import javax.persistence.*;

@Entity
@Table(name = "item_requester")
public class Item_Requester {
    @Id
    @SequenceGenerator(
            name = "item_requester_id_seq",
            sequenceName = "item_requester_id_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_requester_id_seq"
    )

    private long id;
    private int account_id;
    private int loan_post_id;

    public Item_Requester() {
    }

    public Item_Requester(int account_id, int loan_post_id) {
        this.account_id = account_id;
        this.loan_post_id = loan_post_id;
    }

    public Item_Requester(long id, int account_id, int loan_post_id) {
        this.id = id;
        this.account_id = account_id;
        this.loan_post_id = loan_post_id;
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

    public int getLoan_post_id() {
        return loan_post_id;
    }

    public void setLoan_post_id(int loan_post_id) {
        this.loan_post_id = loan_post_id;
    }

    @Override
    public String toString() {
        return "Item_Requester{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", loan_post_id=" + loan_post_id +
                '}';
    }
}
