package mau.project.sharepool.invite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {

    List<Invite> findAllByInvitedId(Long id);
    boolean existsByIdAndInvitedId(Long invite_id, Long account_id);

    @Procedure(name = "test2")
    boolean test2(boolean a, Long account_id ,Long community_id);


}
