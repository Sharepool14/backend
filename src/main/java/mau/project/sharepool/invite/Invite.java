package mau.project.sharepool.invite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mau.project.sharepool.account.Account;
import mau.project.sharepool.community.Community;

import javax.persistence.*;

@Entity
@Table(name = "invite")
public class Invite {

    @Id
    @SequenceGenerator(
            name = "invite_id_seq",
            sequenceName = "invite_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invite_id_seq"
    )

    private long id;

    @ManyToOne
    @JoinColumn(name = "inviter")
    private Account inviter;

    @ManyToOne
    @JoinColumn(name = "invited")
    private Account invited;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    public Invite() {
    }

    public Invite(Account inviter, Account invited, Community community) {
        this.inviter = inviter;
        this.invited = invited;
        this.community = community;
    }

    public Invite(long id, Account inviter, Account invited, Community community) {
        this.id = id;
        this.inviter = inviter;
        this.invited = invited;
        this.community = community;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getInviter() {
        return inviter;
    }

    public void setInviter(Account inviter) {
        this.inviter = inviter;
    }

    public Account getInvited() {
        return invited;
    }

    public void setInvited(Account invited) {
        this.invited = invited;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "id=" + id +
                ", inviter=" + inviter +
                ", invited=" + invited +
                ", community=" + community +
                '}';
    }
}

