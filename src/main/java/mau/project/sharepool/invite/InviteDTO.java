package mau.project.sharepool.invite;

/**
 * @author Hugo Lindstedt
 * Data Transfer Object class that is used to map information from the Invite table to frontend.
 */
public class InviteDTO {
    private long id;
    private String inviter;
    private String invited;
    private String community;

    public InviteDTO() {
    }

    public InviteDTO(long id ,String inviter, String invited, String community) {
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

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public String getInvited() {
        return invited;
    }

    public void setInvited(String invited) {
        this.invited = invited;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "InviteDTO{" +
                "id=" + id +
                ", inviter='" + inviter + '\'' +
                ", invited='" + invited + '\'' +
                ", community='" + community + '\'' +
                '}';
    }
}
