package de.thb.giftmanager.services;
import de.thb.giftmanager.entity.Event;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.repository.GiftListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class GiftListService {
    @Autowired
    private GiftListRepository giftListRepository;

    public List<GiftList> getAllGiftLists() {
        return (List<GiftList>) giftListRepository.findAll();

        //TODO: Set event as standard sorting order for MyLists-View
        //return (List<GiftList>) giftListRepository.findAllOrderedByEvent();
    }

    public Optional<GiftList> getGiftListByID(long id) {
        return giftListRepository.findById(id);
    }


    //TODO: add validation logic
    public GiftList addGiftList(String title, Event event, Date dueDate, double totalPrice) {

        return giftListRepository.save(GiftList.builder()
                .title(title)
                .event(event)
                .dueDate(dueDate)
                .totalPrice(totalPrice)
                .build());
    }


}
