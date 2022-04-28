package mau.project.sharepool.item_requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Item_RequesterService {
    private Item_RequesterRepository item_requesterRepository;

    @Autowired
    public Item_RequesterService(Item_RequesterRepository item_requesterRepository){
        this.item_requesterRepository  = item_requesterRepository;
    }
}
