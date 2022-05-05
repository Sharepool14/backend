package mau.project.sharepool.community_account;

import mau.project.sharepool.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Community_AccountRepository extends JpaRepository<Community, Long> {
     //List<Community> find(String community_account);
     //List<Community> findByAccount_Login_Username(String username);
}
