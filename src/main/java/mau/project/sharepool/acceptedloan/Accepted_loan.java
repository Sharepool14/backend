package mau.project.sharepool.acceptedloan;

import com.fasterxml.jackson.annotation.JsonProperty;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.itemrequester.Item_Requester;

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

    @OneToOne
    @JoinColumn(name = "item_requester_id", referencedColumnName = "id")
    private Item_Requester item_requester;
    @JsonProperty("returned")
    private boolean returned;

    public Accepted_loan() {
    }

    public Accepted_loan(Item item_requeste, boolean returned) {
        this.item_requester = item_requester;
        this.returned = returned;
    }

    public Accepted_loan(long id, Item_Requester item_requester, boolean returned) {
        this.id = id;
        this.item_requester = item_requester;
        this.returned = returned;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item_Requester getItem_requester() {
        return item_requester;
    }

    public void setItem_requester(Item_Requester item_requester) {
        this.item_requester = item_requester;
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
                ", item_requester{" +  item_requester.toString() +
                "} , returned=" + returned +
                '}';
    }
}
