package mau.project.sharepool.community;

import mau.project.sharepool.community_account.Community_Account;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "community")
public class Community {
    @Id
    @SequenceGenerator(
            name = "community_id_seq",
            sequenceName = "community_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "community_id_seq"
    )

    private long id;
    private String name;
    @ManyToOne
    @JoinColumns({
              @JoinColumn(name = "community_account_accountId", referencedColumnName = "accountId"),
              @JoinColumn(name = "community_account_communityId", referencedColumnName = "communityId")
    })
    private Community_Account community_account;

    public Community() {
    }

    public Community(String name, Community_Account community_account) {
        this.name = name;
        this.community_account = community_account;
    }

    public Community(long id, String name, Community_Account community_account) {
        this.id = id;
        this.name = name;
        this.community_account = community_account;
    }

    public long getId() {
        return id;
    }

    public void setId(long community_id) {
        this.id = community_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Community_Account getCommunity_account() {
        return community_account;
    }

    public void setCommunity_account(Community_Account community_account) {
        this.community_account = community_account;
    }
    @Override
    public String toString() {
        return "Community{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", community_account=" + community_account +
                  '}';
    }
}