package mau.project.sharepool.acceptedloan;

import com.fasterxml.jackson.annotation.JsonProperty;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.item.Item;
//import mau.project.sharepool.itemrequester.Item_Requester;
import mau.project.sharepool.loanpost.Loan_Post;

import javax.persistence.*;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @SequenceGenerator(
            name = "accepted_loan_id_seq",
            sequenceName = "accepted_loan_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accepted_loan_id_seq"
    )

    private long id;

    /*@OneToOne
    @JoinColumn(name = "item_requester_id", referencedColumnName = "id")
    private Item_Requester item_requester;*/

    @OneToOne
    private Account reqeuster;

    @OneToOne
    private Loan_Post loan_post;

    private boolean accepted;

    @JsonProperty("returned")
    private boolean returned;

    public Loan() {
    }

    public Loan(Account reqeuster, Loan_Post loan_post, boolean accepted, boolean returned) {
        this.reqeuster = reqeuster;
        this.loan_post = loan_post;
        this.accepted = accepted;
        this.returned = returned;
    }

    public Loan(long id, Account reqeuster, Loan_Post loan_post, boolean accepted, boolean returned) {
        this.id = id;
        this.reqeuster = reqeuster;
        this.loan_post = loan_post;
        this.accepted = accepted;
        this.returned = returned;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getReqeuster() {
        return reqeuster;
    }

    public void setReqeuster(Account reqeuster) {
        this.reqeuster = reqeuster;
    }

    public Loan_Post getLoan_post() {
        return loan_post;
    }

    public void setLoan_post(Loan_Post loan_post) {
        this.loan_post = loan_post;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", reqeuster=" + reqeuster +
                ", loan_post=" + loan_post +
                ", accepted=" + accepted +
                ", returned=" + returned +
                '}';
    }
}
