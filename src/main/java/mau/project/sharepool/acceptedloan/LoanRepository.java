package mau.project.sharepool.acceptedloan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface LoanRepository extends JpaRepository<Loan, Long> {
     /**
      * @author Anthon Haväng
      */
     boolean existsAllByAccount_IdAndReturnedIsFalse(Long accountID);

     List<Loan> findAllByAccountId(Long id);
     List<Loan> findAllByRequesterId(Long id);

}
