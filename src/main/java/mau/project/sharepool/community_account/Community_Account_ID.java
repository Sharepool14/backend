package mau.project.sharepool.community_account;

import java.io.Serializable;
import java.util.Objects;

public class Community_Account_ID implements Serializable {
     private Long accountId;
     private Long communityId;

     public Community_Account_ID() {
     }

     public Community_Account_ID(Long account_ID, Long community_ID) {
          this.accountId = account_ID;
          this.communityId = community_ID;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Community_Account_ID that = (Community_Account_ID) o;
          return Objects.equals(accountId, that.accountId) && Objects.equals(communityId, that.communityId);
     }

     @Override
     public int hashCode() {
          return Objects.hash(accountId, communityId);
     }
}
