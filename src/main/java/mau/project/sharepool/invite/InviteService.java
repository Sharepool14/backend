package mau.project.sharepool.invite;

import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InviteService {
    private InviteRepository inviteRepository;

    @Autowired
    public InviteService(InviteRepository inviteRepository){
        this.inviteRepository = inviteRepository;
    }

    public List<InviteDTO> getSpecificInvite() {
        List<Invite> invites = inviteRepository.findAllByInvitedId(AccountID.get());
        List<InviteDTO> inviteDTO = new ArrayList<>();

        invites.stream()
                .forEach(invite -> {
                    InviteDTO dto = new InviteDTO();
                    dto.setInvited(invite.getInvited().getUsername());
                    dto.setInviter(invite.getInviter().getUsername());
                    dto.setCommunity(invite.getCommunity().getName());
                    dto.setId(invite.getId());
                    inviteDTO.add(dto);
                });
        return inviteDTO;
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
