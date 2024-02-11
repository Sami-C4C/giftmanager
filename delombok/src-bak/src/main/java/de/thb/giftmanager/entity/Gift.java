package de.thb.giftmanager.entity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Getter
@Setter
@Table(name = "gift")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private GiftCategory category;
    private int ean;
    private double price;
    private String link;
    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreation;

    /*
     * will be connected with giftlist,if the
     * list is deleted,its added gifts will also
     * be deleted automatically.
     * Relationship = many gifts ---to one----> list
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private GiftList giftList;

}
