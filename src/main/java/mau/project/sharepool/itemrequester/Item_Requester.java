package mau.project.sharepool.itemrequester;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.loanpost.Loan_Post;

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

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loan_post_id", referencedColumnName = "id")
    private Loan_Post loan_post;

    public Item_Requester() {
    }

    public Item_Requester(Account account, Loan_Post loan_post) {
        this.account = account;
        this.loan_post = loan_post;
    }

    public Item_Requester(long id, Account account, Loan_Post loan_post) {
        this.id = id;
        this.account = account;
        this.loan_post = loan_post;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public Loan_Post getLoan_post() {
        return loan_post;
    }

    public void setLoan_post(Loan_Post loan_post) {
        this.loan_post = loan_post;
    }

    @Override
    public String toString() {
        return "Item_Requester{" +
                "id=" + id +
                ", account_id=" + account +
                ", loan_post_id=" + loan_post +
                '}';
    }
}
