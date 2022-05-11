package mau.project.sharepool.invite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {

    List<Invite> findAllByInvitedId(Long id);


}
