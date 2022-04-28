package mau.project.sharepool.image;


import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @SequenceGenerator(
            name = "image_id_seq",
            sequenceName = "image_id_seq",
            allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_id_seq"
    )

    private long id;
    private String path;
    private int item_id;
}
