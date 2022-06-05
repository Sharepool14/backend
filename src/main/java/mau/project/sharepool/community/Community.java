package mau.project.sharepool.community;

import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.loanpost.Loan_Post;
import mau.project.sharepool.invite.Invite;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * @author Elisabet Aronsson
 */
@Entity
@Table(name = "community")
public class Community {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Set<Loan_Post> getLoan_posts() {
        return loan_posts;
    }

    public void setLoan_posts(Set<Loan_Post> loan_posts) {
        this.loan_posts = loan_posts;
    }

    @Override
    public String toString() {
        return "Community{" +
                "community_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}