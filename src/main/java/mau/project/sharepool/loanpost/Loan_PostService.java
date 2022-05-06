package mau.project.sharepool.loanpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Loan_PostService {
    private final Loan_PostRepository loan_postRepository;

    @Autowired
    private Loan_PostService(Loan_PostRepository loan_postRepository){
        this.loan_postRepository = loan_postRepository;
    }
}
