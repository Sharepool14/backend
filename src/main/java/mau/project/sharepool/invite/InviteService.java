package mau.project.sharepool.invite;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.communityaccount.CommunityAccount;
import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InviteService {
    private InviteRepository inviteRepository;
    private CommunityAccountRepository communityAccountRepository;

    @Autowired
    public InviteService(InviteRepository inviteRepository,CommunityAccountRepository communityAccountRepository){
        this.inviteRepository = inviteRepository;
        this.communityAccountRepository = communityAccountRepository;
    }

    /**
     * @author Robert Korpics
     * return inviteDTO
     */

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

    public void handleInvite(Long invite_id) {
        Long account_id = AccountID.get();
        if (inviteRepository.existsByIdAndInvitedId(invite_id,account_id)) {
            Account account = new Account();
            account.setId(account_id);
            communityAccountRepository.save(new CommunityAccount(account,inviteRepository.getById(invite_id).getCommunity(),1));
            inviteRepository.deleteById(invite_id);
        }
    }
}
