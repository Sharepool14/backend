package mau.project.sharepool.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Robert Korpics
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
