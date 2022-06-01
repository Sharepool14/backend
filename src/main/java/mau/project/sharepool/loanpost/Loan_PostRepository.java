package mau.project.sharepool.loanpost;

import mau.project.sharepool.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Loan_PostRepository extends JpaRepository<Loan_Post, Long> {
    List<Loan_Post> findAllByCommunity_id(Long communityID);
    boolean existsByAccountIdAndItemIdAndVisibleIsTrueAndCommunityId(Long account_id,Long item_id,Long community_id);

    List<Loan_Post> findAllByCommunity_idIn(List<Long> community_id);

    List<Loan_Post> findAllByCommunity_idInAndVisibleIsTrue(List<Long> community_id);
    List<Loan_Post> findAllByAccountId(Long account_id);
    //List<Loan_Post> findAllByCommunity_idInAAndVisibleIsTrue(List<Long> community_id);

}
