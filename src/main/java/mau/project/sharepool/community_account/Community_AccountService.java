package mau.project.sharepool.community_account;

import mau.project.sharepool.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Community_AccountService {
     private Community_AccountRepository repository;

     @Autowired
     public Community_AccountService(Community_AccountRepository repository){
          this.repository = repository;
     }


     public List<Community> listUsersCommunities(String account_id) {
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          if (!authentication.getName().equals(account_id)){
               return null;
          }
          return repository.findByAccount_Login_Username(account_id);
     }

}