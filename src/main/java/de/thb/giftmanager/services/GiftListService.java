package de.thb.giftmanager.services;

import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.exception.GiftListNotFoundException;
import de.thb.giftmanager.exception.OverBudgetException;
import de.thb.giftmanager.repository.GiftListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiftListService {

    @Autowired
    private GiftListRepository giftListRepository;

    public List<GiftList> getAllGiftLists() {
        List<GiftList> giftLists = giftListRepository.findAll();
        giftLists.forEach(GiftList::updateTotalPrice);
        return giftLists;
    }

    public Optional<GiftList> getGiftListByID(long id) {
        return giftListRepository.findById(id);
    }

    public void saveGiftList(GiftList giftList) {
        giftList.updateTotalPrice();
        giftListRepository.save(giftList);
    }

    public GiftList getGiftList(Long id) throws GiftListNotFoundException {
        Optional<GiftList> giftList = giftListRepository.findById(id);
        if (giftList.isPresent()) {
            GiftList list = giftList.get();
            list.updateTotalPrice();
            return list;
        }
        throw new GiftListNotFoundException("No GiftList found with this ID: " + id);
    }

    public void deleteGiftList(Long id) throws GiftListNotFoundException {
        giftListRepository.findById(id)
                .orElseThrow(() -> new GiftListNotFoundException("No Gift was found with this ID: " + id));
        giftListRepository.deleteById(id);
    }

   /* public void addGiftToGiftList(Gift gift, GiftList giftList) {
        double newTotalPrice = giftList.getTotalPrice() + gift.getPrice();
        if (newTotalPrice > giftList.getBudget()) {
            throw new OverBudgetException("Gift Price is over List-Budget");
        }
        giftList.getGifts().add(gift);
        giftList.updateTotalPrice();
        giftListRepository.save(giftList);
    }*/
}
