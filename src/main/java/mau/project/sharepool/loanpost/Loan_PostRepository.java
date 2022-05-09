package mau.project.sharepool.loanpost;

import mau.project.sharepool.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Loan_PostRepository extends JpaRepository<Loan_Post, Long> {
    List<Loan_Post> findAllByCommunity_id(Long communityID);
}
