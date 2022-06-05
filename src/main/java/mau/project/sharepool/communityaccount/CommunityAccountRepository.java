package mau.project.sharepool.communityaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * @author Anthon Haväng
 * Repository class for the CommunityAccount package. Used to define certain calls to the database using Spring tool.
 */
@Repository
public interface CommunityAccountRepository extends JpaRepository<CommunityAccount, Long> {
    Set<CommunityAccount> findAllByAccountId(Long id);

    boolean existsByAccount_idAndCommunity_id(Long account_id, Long community_id);
    boolean existsByAccountIdAndCommunityIdAndRoleGreaterThan(Long account_id, Long community_id, int role);
    Optional<CommunityAccount> findByAccountIdAndCommunityId(Long account_id, Long community_id);

     /**
      * @author Anthon Haväng
      */
    void deleteByAccount_IdAndCommunity_Id(Long account_id, Long community_id);


     /**
      * @author Anthon Haväng
      */
     Set<CommunityAccount> findAllByCommunityId(Long communityID);
}
