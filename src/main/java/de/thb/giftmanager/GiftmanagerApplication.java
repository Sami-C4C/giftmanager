package de.thb.giftmanager;

import de.thb.giftmanager.entity.Event;
import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftCategory;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.services.GiftListService;
import de.thb.giftmanager.services.GiftsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GiftmanagerApplication {

//   static GiftList giftList1;
//   static GiftList giftList2;

    public static void main(String[] args) {
        SpringApplication.run(GiftmanagerApplication.class, args);
    }


   /* @Bean
    CommandLineRunner runner(GiftListService giftListService, GiftsService giftsService) throws IllegalArgumentException {

        Gift gift1 = new Gift(1, "HP Laptop", GiftCategory.ELECTRONICS, 123, 650, "https://www.amazon.de", new Date("2022-11-25"), giftList1);
        Gift gift2 = new Gift(2, "Dior Perfume", GiftCategory.PERFUMES, 456, 130, "https://www.ebay.com", new Date("2022-11-26"), giftList1);
        List<Gift> group1 = new ArrayList<>();
        group1.add(gift1);
        group1.add(gift2);
         giftList1 = new GiftList(1, "1st List", Event.CHRISTMAS, new Date("2022-11-23"), 0.0, 800, group1);

//        -----------------------------------
        Gift gift3 = new Gift(3, "sport shoes", GiftCategory.MODE, 257, 80, "https://www.salando.de", new Date("2022-11-28"), giftList2);
        Gift gift4 = new Gift(4, "Schokolade", GiftCategory.FOODS, 789, 20, "https://www.ebay.de", new Date("2023-12-12"), giftList2);

        List<Gift> group2 = new ArrayList<>();
        group2.add(gift3);
        group2.add(gift4);


        giftList2 = new GiftList(2, "2nd List", Event.BIRTHDAY, new Date("2022-12-12"), 0.0, 250, group2);


        return args -> {
            giftListService.saveGiftList(giftList1);
            giftListService.saveGiftList(giftList2);
            giftsService.saveGift(gift1);
            giftsService.saveGift(gift2);
            giftsService.saveGift(gift3);
            giftsService.saveGift(gift4);



        };
    }*/
}

