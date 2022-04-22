package mau.project.sharepool.invite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteService {
    private InviteRepository inviteRepository;

    public List<Invite> getInvites() {
        return inviteRepository.findAll();
    }

    public void addInvite(Invite invite) {
        inviteRepository.save(invite);
    }

    public void deleteAInvite(Long id) {
        inviteRepository.deleteById(id);
    }
}
