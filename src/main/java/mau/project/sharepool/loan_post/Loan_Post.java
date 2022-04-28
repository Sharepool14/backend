package mau.project.sharepool.loan_post;


import javax.persistence.*;
import java.util.Date;

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
    private int item_id;
    private int community_id;

    public Loan_Post() {
    }

    public Loan_Post(Date start_date, Date return_date, int item_id, int community_id) {
        this.start_date = start_date;
        this.return_date = return_date;
        this.item_id = item_id;
        this.community_id = community_id;
    }

    public Loan_Post(long id, Date start_date, Date return_date, int item_id, int community_id) {
        this.id = id;
        this.start_date = start_date;
        this.return_date = return_date;
        this.item_id = item_id;
        this.community_id = community_id;
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    @Override
    public String toString() {
        return "Loan_Post{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", return_date=" + return_date +
                ", item_id=" + item_id +
                ", community_id=" + community_id +
                '}';
    }
}