package mau.project.sharepool.invite;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {

    /**
     * @author Robert Korpics
     */
    List<Invite> findAllByInvitedId(Long id);
    boolean existsByIdAndInvitedId(Long invite_id, Long account_id);
}
