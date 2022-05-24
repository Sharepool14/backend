package mau.project.sharepool.acceptedloan;

import com.fasterxml.jackson.annotation.JsonProperty;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.loanpost.Loan_Post;

import javax.persistence.*;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Account requester;

    @OneToOne
    private Loan_Post loan_post;

    private boolean accepted;

    @ManyToOne
    private Account account;

    @JsonProperty("returned")
    private boolean returned;

    public Loan() {
    }

    public Loan(Account requester, Loan_Post loan_post, boolean accepted, boolean returned) {
        this.requester = requester;
        this.loan_post = loan_post;
        this.accepted = accepted;
        this.returned = returned;
    }

    public Loan(long id, Account requester, Loan_Post loan_post, boolean accepted, boolean returned) {
        this.id = id;
        this.requester = requester;
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

    public Account getRequester() {
        return requester;
    }

    public void setRequester(Account reqeuster) {
        this.requester = reqeuster;
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
                ", requester =" + requester +
                ", loan_post=" + loan_post +
                ", accepted=" + accepted +
                ", returned=" + returned +
                '}';
    }
}
