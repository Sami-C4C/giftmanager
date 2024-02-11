package de.thb.giftmanager.services;


import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftCategory;
import de.thb.giftmanager.repository.GiftListRepository;
import de.thb.giftmanager.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * We can take reference of GiftListRepository and make the Implementation direct in Controller, but it's better to have the reference
 * and Implementation into class Service, i.e, Service is the Implementation of Repository.
 */
@Service
public class GiftsService {

    @Autowired
    private GiftRepository giftRepository;

    public List<Gift> getAllGifts() {
        return (List<Gift>) giftRepository.findAll();

        //TODO: Set dateOfCreation as standard sorting order for Giftpool-View
        //return (List<GiftList>) giftListRepository.findAllOrderedByEvent();
    }


    public Optional<Gift> getGiftByID(long id) {
        return giftRepository.findById(id);
    }

    public void addGift(Gift newGift) {
        giftRepository.save(newGift);
    }


    //TODO: add validation logic
    public Gift addGift(String title, GiftCategory category, int ean, double price, String link, Date dateOfCreation) {

        return giftRepository.save(Gift.builder()
                .title(title)
                .category(category)
                .ean(ean)
                .price(price)
                .link(link)
                .dateOfCreation(dateOfCreation)
                .build());
    }


    public void saveGift(Gift gift) {
        giftRepository.save(gift);
    }

    public Gift get(Long id){
        return giftRepository.findById(id).get();
    }

    public void deleteGift(Long id) {
        giftRepository.deleteById(id);
    }

}
