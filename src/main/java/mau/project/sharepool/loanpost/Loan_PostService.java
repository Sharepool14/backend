package mau.project.sharepool.loanpost;

import mau.project.sharepool.account.Account;
import mau.project.sharepool.config.AccountID;
import mau.project.sharepool.item.Item;
import mau.project.sharepool.item.ItemRepository;
import mau.project.sharepool.userinformation.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Loan_PostService {
    private final Loan_PostRepository loan_postRepository;

    @Autowired
    private Loan_PostService(Loan_PostRepository loan_postRepository){
        this.loan_postRepository = loan_postRepository;
    }

    public void updatePost(Loan_Post loan_post){
        Loan_Post loan_post1 = loan_postRepository.getById(loan_post.getId());
        loan_post1.setStart_date(loan_post.getStart_date());
        loan_post1.setReturn_date(loan_post.getReturn_date());
        loan_post1.setItem(loan_post.getItem());
        loan_postRepository.save(loan_post1);
    }

    public List<Loan_Post> all() {
        return loan_postRepository.findAll();
    }
}
