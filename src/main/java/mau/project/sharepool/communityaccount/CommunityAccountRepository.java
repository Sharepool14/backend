package mau.project.sharepool.communityaccount;

import mau.project.sharepool.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommunityAccountRepository extends JpaRepository<CommunityAccount, Long> {
    Set<CommunityAccount> findAllByAccountId(Long id);
}
