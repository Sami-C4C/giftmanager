package de.thb.giftmanager.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString
@Getter
@Setter
@Entity
@Table(name = "gift")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private GiftCategory category;

    @Column(unique = true)
    private int ean;

    private double price;

    private String link;

    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfCreation;


    @ManyToOne
    @JoinColumn(name = "giftlist_id")
    private GiftList giftList;

}
