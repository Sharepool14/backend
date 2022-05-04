package mau.project.sharepool.community_account;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.community.Community;
import mau.project.sharepool.role.Role;

import javax.persistence.*;

@Entity
@Table(name = "community_account")
//@IdClass(Community_Account_PK.class)
public class Community_Account  {

     @EmbeddedId
     private Community_Account_PK pk;

     @ManyToOne
     @MapsId("account_id")
     @JoinColumn(name = "account_id")
     private Account account;

     @ManyToOne
     @MapsId("community_id")
     @JoinColumn(name = "community_id")

     private Community community;

     @OneToOne

     private Role role;


     public Community_Account(Account account, Community community, Role role) {
          this.account = account;
          this.community = community;
          this.role = role;
     }

     public Community_Account(Role role) {
          this.role = role;
     }

     public Community_Account() {
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

     public Role getRole() {
          return role;
     }

     public void setRole(Role role) {
          this.role = role;
     }

     @Override
     public String toString() {
          return "Community_Account{" +
                    "account=" + account +
                    ", community=" + community +
                    ", role=" + role +
                    '}';
     }
}
