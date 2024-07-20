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


@SpringBootApplication
public class GiftmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiftmanagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(GiftListService giftListService, GiftsService giftsService) {
        return args -> {
            // Creating GiftList1 and its gifts
            GiftList giftList1 = new GiftList(1, "1st List", Event.CHRISTMAS, new Date(), 0.0, 800.0, new ArrayList<>());
            Gift gift1 = new Gift(1, "HP Laptop", GiftCategory.ELECTRONICS, 123, 650.0, "https://www.amazon.de", new Date(), giftList1);
            Gift gift2 = new Gift(2, "Dior Perfume", GiftCategory.PERFUMES, 456, 130.0, "https://www.ebay.com", new Date(), giftList1);
            giftList1.getGifts().add(gift1);
            giftList1.getGifts().add(gift2);

            // Creating GiftList2 and its gifts
            GiftList giftList2 = new GiftList(2, "2nd List", Event.BIRTHDAY, new Date(), 0.0, 250.0, new ArrayList<>());
            Gift gift3 = new Gift(3, "Sport Shoes", GiftCategory.MODE, 257, 80.0, "https://www.salando.de", new Date(), giftList2);
            Gift gift4 = new Gift(4, "Schokolade", GiftCategory.FOODS, 789, 20.0, "https://www.ebay.de", new Date(), giftList2);
            giftList2.getGifts().add(gift3);
            giftList2.getGifts().add(gift4);

            // Saving gift lists and gifts
            giftListService.saveGiftList(giftList1);
            giftListService.saveGiftList(giftList2);
            giftsService.saveGift(gift1);
            giftsService.saveGift(gift2);
            giftsService.saveGift(gift3);
            giftsService.saveGift(gift4);
        };
    }
}
