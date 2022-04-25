package mau.project.sharepool.community;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @SequenceGenerator(
            name = "community_id_seq",
            sequenceName = "community_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "community_id_seq"
    )

    private long id;
    private String name;

    public Community() {
    }

    public Community(String name) {
        this.name = name;
    }

    public Community(long community_id, String name) {
        this.id = community_id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long community_id) {
        this.id = community_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Community{" +
                "community_id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}