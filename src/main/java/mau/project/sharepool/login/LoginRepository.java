package mau.project.sharepool.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login2,Long> {
    public Login2 findByUsername(String username);
}
