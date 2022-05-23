package mau.project.sharepool.community;

import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.invite.Invite;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

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
    @OneToMany(mappedBy = "community")
    private Set<CommunityAccount> communityAccounts;

    @OneToMany(mappedBy = "community")
    private Set<Loan_Post> loan_posts;

    @OneToMany(mappedBy = "community" )
    private Set<Invite> invites;

    @OneToMany(mappedBy = "community")
    private Set<Loan_Post> posts;

    public Community() {
    }


    public Community(String name) {
        this.name = name;
    }

    public Community(long community_id, String name) {
        this.id = community_id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Community{" +
                "community_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}