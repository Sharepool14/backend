package mau.project.sharepool.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    Set<Item> findAllByAccountId(long id);
}

