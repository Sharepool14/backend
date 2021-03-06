package mau.project.sharepool.loanpost;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * @author Elisabet Aronsson and Hugo Lindstedt
 */

@Repository
public interface Loan_PostRepository extends JpaRepository<Loan_Post, Long> {
    List<Loan_Post> findAllByCommunity_id(Long communityID);
    boolean existsByAccountIdAndItemIdAndVisibleIsTrueAndCommunityId(Long account_id,Long item_id,Long community_id);
    List<Loan_Post> findAllByCommunity_idIn(List<Long> community_id);
    List<Loan_Post> findAllByCommunity_idInAndVisibleIsTrue(List<Long> community_id);
    List<Loan_Post> findAllByAccountId(Long account_id);
}
