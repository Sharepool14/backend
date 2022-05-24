package mau.project.sharepool.acceptedloan;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

public interface LoanRepository extends JpaRepository<Loan, Long> {
     /**
      * @author Anthon Haväng
      */
     boolean existsAllByAccount_IdAndReturnedIsFalse(Long accountID);

     Set<Loan> findAllByAccountId(Long id);
     Set<Loan> findAllByRequesterId(Long id);
}
