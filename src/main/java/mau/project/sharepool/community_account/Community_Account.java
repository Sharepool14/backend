package mau.project.sharepool.community_account;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "community_account")
@IdClass(Community_Account_PK.class)
public class Community_Account implements Serializable {
     @Id
     private long accountId;
     @Id
     private long communityId;
     private int role;


     public Community_Account() {
     }

     public Community_Account(long accountId, long communityId, int role) {
          this.accountId = accountId;
          this.communityId = communityId;
          this.role = role;
     }

     public Community_Account(int role) {
          this.role = role;
     }

     public long getAccountId() {
          return accountId;
     }

     public void setAccountId(long accountId) {
          this.accountId = accountId;
     }

     public long getCommunityId() {
          return communityId;
     }

     public void setCommunityId(long communityId) {
          this.communityId = communityId;
     }

     public int getRole() {
          return role;
     }

     public void setRole(int role) {
          this.role = role;
     }

     @Override
     public String toString() {
          return "Community_Account{" +
                    "accountId=" + accountId +
                    ", communityId=" + communityId +
                    ", role=" + role +
                    '}';
     }
}
