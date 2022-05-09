package mau.project.sharepool.communityaccount;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.community.Community;
import javax.persistence.*;

@Entity
@Table
public class CommunityAccount {
    /*private final String STANDARD_USER = 1;
    private final String INVETER = 1;
    private final String MODERATOR = 3;
    private final String OWNER = 4;*/

    @EmbeddedId
    CommunityAccountKey id = new CommunityAccountKey();

    @ManyToOne
    @MapsId("account_id")
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @MapsId("community_id")
    @JoinColumn(name = "community_id")
    Community community;
    int role;

    public CommunityAccount() {
    }

    public CommunityAccount(Account account, Community community, int role) {
        this.account = account;
        this.community = community;
        this.role = role;
    }

    public CommunityAccount(CommunityAccountKey id, Account account, Community community, int role) {
        this.id = id;
        this.account = account;
        this.community = community;
        this.role = role;
    }

    public CommunityAccountKey getId() {
        return id;
    }

    public void setId(CommunityAccountKey id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CommunityAccount{" +
                "id=" + id +
                ", account=" + account +
                ", community=" + community +
                ", role=" + role +
                '}';
    }
}
