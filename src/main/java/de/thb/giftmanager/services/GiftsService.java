package de.thb.giftmanager.services;


import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.exception.GiftNotFoundException;
import de.thb.giftmanager.exception.OverBudgetException;
import de.thb.giftmanager.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GiftsService {

    @Autowired
    private GiftRepository giftRepository;

    public List<Gift> getAllGifts() {
        List<Gift> gifts = giftRepository.findAll();
        return gifts;

    }


    public Optional<Gift> getGiftByID(long id) {
        return giftRepository.findById(id);
    }


    public void saveGift(Gift gift) {
        GiftList giftList = gift.getGiftList();
        giftList.setTotalPrice(giftList.getTotalPrice() + gift.getPrice());
        if (giftList.getTotalPrice() > giftList.getBudget()) {
            throw new OverBudgetException("Gift Price is over List-Budget");
        }

        // due to Bi-directional mapping, it will be automatically saved in giftlist
        giftRepository.save(gift);
    }

    public Gift getGift(Long id) throws GiftNotFoundException {
        Optional<Gift> gift = giftRepository.findById(id);
        if (gift.isPresent()) {
            return gift.get();
        }

        throw new GiftNotFoundException("No Gift Found with this ID: " + id);
    }

    public void deleteGift(Long id) throws GiftNotFoundException {
        Gift gift = giftRepository.findById(id).orElseThrow(() -> new GiftNotFoundException("No Gift was found with this ID: " + id));
        gift.getGiftList().setTotalPrice(gift.getGiftList().getTotalPrice() - gift.getPrice());
        giftRepository.deleteById(id);
    }

}
