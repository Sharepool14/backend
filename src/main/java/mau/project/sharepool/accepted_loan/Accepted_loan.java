package mau.project.sharepool.accepted_loan;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "accepted_loan")
public class Accepted_loan {

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
    private int item_requester_id;
    @JsonProperty("returned")
    private boolean returned;

    public Accepted_loan() {
    }

    public Accepted_loan(int item_requester_id, boolean returned) {
        this.item_requester_id = item_requester_id;
        this.returned = returned;
    }

    public Accepted_loan(long id, int item_requester_id, boolean returned) {
        this.id = id;
        this.item_requester_id = item_requester_id;
        this.returned = returned;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getItem_requester_id() {
        return item_requester_id;
    }

    public void setItem_requester_id(int item_requester_id) {
        this.item_requester_id = item_requester_id;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Accepted_loan{" +
                "id=" + id +
                ", item_requester_id=" + item_requester_id +
                ", returned=" + returned +
                '}';
    }
}
