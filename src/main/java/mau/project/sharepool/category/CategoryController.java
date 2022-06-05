package mau.project.sharepool.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Robert Korpics
 */

@RestController
@RequestMapping (path = "/user/category")
public class CategoryController {
    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }

    /**
     * @author Robert Korpics
     * Fetches the categories
     */

    @GetMapping(path = "all")
    public List getCategory(){
        return service.getCategories();
    }

    /**
     * @author Robert Korpics
     * Param category
     * Adds a category
     */

    @PostMapping(path = "add")
    public ResponseEntity add(@RequestBody Category category){
        service.addToCategory(category);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * @author Robert Korpics
     * Param id
     * Deletes a category
     */

    @DeleteMapping(path = "delete")
    public ResponseEntity delete(@RequestBody Long id){
        service.deleteCategory(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * @author Robert Korpics
     * Deletes all categories
     */

    @PostMapping(path = "deleteAll")
    public ResponseEntity deleteALl(){
        service.deleteAllCategories();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
