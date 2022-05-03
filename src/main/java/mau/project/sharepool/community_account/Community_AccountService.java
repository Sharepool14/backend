package mau.project.sharepool.community_account;

import mau.project.sharepool.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Community_AccountService {
     private Community_AccountRepository repository;

     @Autowired
     public Community_AccountService(Community_AccountRepository repository){
          this.repository = repository;
     }

     public List<Community> listUsersCommunities() {
          return repository.findAll();
     }
}
