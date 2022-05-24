package mau.project.sharepool.acceptedloan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Set<Loan> findAllByAccountId(Long id);

    Set<Loan> findAllByRequesterId(Long id);
}
