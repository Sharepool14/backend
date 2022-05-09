package mau.project.sharepool.itemrequester;

import mau.project.sharepool.communityaccount.CommunityAccountRepository;
import mau.project.sharepool.config.AccountID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Item_RequesterService {
    private final Item_RequesterRepository item_requesterRepository;
    private final CommunityAccountRepository communityAccountRepository;

    @Autowired
    public Item_RequesterService(Item_RequesterRepository item_requesterRepository, CommunityAccountRepository communityAccountRepository){
        this.item_requesterRepository  = item_requesterRepository;
        this.communityAccountRepository = communityAccountRepository;
    }

    public void requestAPost(Item_Requester item_requester, Long communityID) {
        if (communityAccountRepository.existsByAccount_idAndCommunity_id(AccountID.get(), communityID)) {
            Item_Requester item_requester1 = item_requester;
            item_requester1.setLoan_post(item_requester.getLoan_post());
            item_requesterRepository.save(item_requester1);
        }
    }

    public List<Item_Requester> getAll() {
        return item_requesterRepository.findAll();
    }
}
