package mau.project.sharepool.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

/**
 * @author Anthon Haväng
 * Repository class for the Item-package. Used to define certain calls to the database using Spring tool.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    Set<Item> findAllByAccountId(long id);
    boolean existsByIdAndAccountId(Long item_id, Long account_id);
}

