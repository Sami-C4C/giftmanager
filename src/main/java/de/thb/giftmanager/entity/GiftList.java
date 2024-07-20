package de.thb.giftmanager.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "budget")
    private double budget;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giftList", orphanRemoval = true)
    private List<Gift> gifts = new ArrayList<>();

    public double calculateTotalPrice() {
        return gifts != null ? gifts.stream().mapToDouble(Gift::getPrice).sum() : 0;
    }

    @PrePersist
    @PreUpdate
    public void updateTotalPrice() {
        this.totalPrice = calculateTotalPrice();
    }
}
