package mau.project.sharepool.invite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteService {
    private InviteRepository inviteRepository;

    @Autowired
    public InviteService(InviteRepository inviteRepository){
        this.inviteRepository = inviteRepository;
    }

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
