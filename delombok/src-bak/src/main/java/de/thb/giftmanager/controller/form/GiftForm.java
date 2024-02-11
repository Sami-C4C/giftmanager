package de.thb.giftmanager.controller.form;


import de.thb.giftmanager.entity.GiftCategory;
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
public class GiftForm {

    private String title;
    //?? @Enumerated(EnumType.STRING)
    private GiftCategory category;
    private int ean;
    private double price;
    private String link;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreation;
}
