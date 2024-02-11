package de.thb.giftmanager.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


import java.util.Date;
import java.util.List;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "giftlist")
public class GiftList {

    @Id
    @Column(name = "giftlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;


    @Enumerated(EnumType.STRING)
    @Column(name = "event")
    private Event event;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dueDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "budget")
    private double budget;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "giftList")
    private List<Gift> gifts;



}
