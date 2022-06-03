package mau.project.sharepool.communityaccount;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Anthon Haväng
 */
@Embeddable
public class CommunityAccountKey implements Serializable {
    @Column(name = "account_id")
    Long account_id;

    @Column(name = "community_id")
    Long community_id;

    /**
     * @author Anthon Haväng
     */
    public CommunityAccountKey() {
    }

    /**
     * @author Anthon Haväng
     */
    public CommunityAccountKey(Long account_id, Long community_id) {
        this.account_id = account_id;
        this.community_id = community_id;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityAccountKey that = (CommunityAccountKey) o;
        return Objects.equals(account_id, that.account_id) && Objects.equals(community_id, that.community_id);
    }
    */

    /**
     * @author Anthon Haväng
     */
    @Override
    public int hashCode() {
        return Objects.hash(account_id, community_id);
    }
}
