package mau.project.sharepool.community;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

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

    private long community_id;
    private String name;
    private int size;
    private int community_score;
    private Date date_created;
    @JsonProperty ("is_visible") // Fixar så att is_visible false på default
    private boolean is_visible;

    public Community() {
    }

    public Community(String name, int size, int community_score, Date date_created, boolean is_visible) {
        this.name = name;
        this.size = size;
        this.community_score = community_score;
        this.date_created = date_created;
        this.is_visible = is_visible;
    }

    public Community(int community_id, String name, int size, int community_score, Date date_created, boolean is_visible) {
        this.community_id = community_id;
        this.name = name;
        this.size = size;
        this.community_score = community_score;
        this.date_created = date_created;
        this.is_visible = is_visible;
    }

    public long getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCommunity_score() {
        return community_score;
    }

    public void setCommunity_score(int community_score) {
        this.community_score = community_score;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public boolean getVisible() {
        return is_visible;
    }

    public void setVisible(boolean visible) {
        is_visible = visible;
    }

    @Override
    public String toString() {
        return "Community{" +
                "community_id=" + community_id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", community_score=" + community_score +
                ", date_created=" + date_created +
                ", isVisible=" + is_visible +
                '}';
    }
}
