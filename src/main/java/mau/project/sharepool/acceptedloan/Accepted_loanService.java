package mau.project.sharepool.acceptedloan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Accepted_loanService {
    private Accepted_loanRepository accepted_loanRepository;

    @Autowired
    public Accepted_loanService(Accepted_loanRepository accepted_loanRepository){

    }
}
