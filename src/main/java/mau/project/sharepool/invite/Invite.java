package mau.project.sharepool.invite;

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
            generator = "account_id_seq"
    )

    private long id;
    private int inviter;
    private int invited;
    private int community_id;

    public Invite() {
    }

    public Invite(int inviter, int invited, int community_id) {
        this.inviter = inviter;
        this.invited = invited;
        this.community_id = community_id;
    }

    public Invite(long id, int inviter, int invited, int community_id) {
        this.id = id;
        this.inviter = inviter;
        this.invited = invited;
        this.community_id = community_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getInviter() {
        return inviter;
    }

    public void setInviter(int inviter) {
        this.inviter = inviter;
    }

    public int getInvited() {
        return invited;
    }

    public void setInvited(int invited) {
        this.invited = invited;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "id=" + id +
                ", inviter=" + inviter +
                ", invited=" + invited +
                ", community_id=" + community_id +
                '}';
    }
}

