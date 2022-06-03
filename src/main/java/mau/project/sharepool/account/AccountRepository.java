package mau.project.sharepool.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);

    @Query(value = "SELECT * FROM account WHERE account.id IN :inList ", nativeQuery = true)
    Account test(List<Integer> inList);
}
