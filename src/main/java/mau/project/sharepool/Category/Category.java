package mau.project.sharepool.Category;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_id_seq",
            sequenceName = "category_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_seq"
    )

    private long id;
    private String type;

    public Category() {
    }

    public Category(String type) {
        this.type = type;
    }

    public Category(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}