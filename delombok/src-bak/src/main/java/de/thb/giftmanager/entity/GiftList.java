package de.thb.giftmanager.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "giftlist")
public class GiftList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Event event;
    @Column(name = "due_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    //@NumberFormat(pattern="xxx")
    private double totalPrice;

    // bi-directional many-to-one association to Note
    // one giftlist contains list of many gifts
    @OneToMany(mappedBy = "giftList", fetch = FetchType.EAGER)
    private List<Gift> gifts;

}
