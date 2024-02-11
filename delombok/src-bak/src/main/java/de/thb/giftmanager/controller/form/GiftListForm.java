package de.thb.giftmanager.controller.form;


import de.thb.giftmanager.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiftListForm {
    private String title;
    //?? @Enumerated(EnumType.STRING)
    private Event event;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    private double totalPrice;

}
