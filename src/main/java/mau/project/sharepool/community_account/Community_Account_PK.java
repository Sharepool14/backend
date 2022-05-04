package mau.project.sharepool.community_account;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Community_Account_PK implements Serializable {
     private Long account_id;
     private Long community_id;

     public Community_Account_PK() {
     }

     public Community_Account_PK(Long account_ID, Long community_ID) {
          this.account_id = account_ID;
          this.community_id = community_ID;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Community_Account_PK that = (Community_Account_PK) o;
          return Objects.equals(account_id, that.account_id) && Objects.equals(community_id, that.community_id);
     }

     @Override
     public int hashCode() {
          return Objects.hash(account_id, community_id);
     }
}
