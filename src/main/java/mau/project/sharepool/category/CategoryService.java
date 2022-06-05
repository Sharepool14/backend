package mau.project.sharepool.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Robert Korpics
 */

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addToCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }
}
