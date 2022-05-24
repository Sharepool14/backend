package mau.project.sharepool.acceptedloan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
     /**
      * @author Anthon Haväng
      */
     boolean existsAllByAccount_IdAndReturnedIsFalse(Long accountID);
}
