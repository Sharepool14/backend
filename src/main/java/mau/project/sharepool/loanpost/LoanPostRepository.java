package mau.project.sharepool.loanpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanPostRepository extends JpaRepository<LoanPost, Long> {
    List<LoanPost> findAllByCommunity_id(Long communityID);
    boolean existsByAccountIdAndItemIdAndVisibleIsTrueAndCommunityId(Long account_id,Long item_id,Long community_id);

    List<LoanPost> findAllByCommunity_idIn(List<Long> community_id);

    List<LoanPost> findAllByCommunity_idInAndVisibleIsTrue(List<Long> community_id);
    //List<Loan_Post> findAllByCommunity_idInAAndVisibleIsTrue(List<Long> community_id);

}
