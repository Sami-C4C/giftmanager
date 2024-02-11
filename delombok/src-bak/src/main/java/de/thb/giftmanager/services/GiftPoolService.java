package de.thb.giftmanager.services;
import com.fasterxml.jackson.annotation.JsonFormat;
import de.thb.giftmanager.entity.Event;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.repository.GiftListRepository;
import de.thb.giftmanager.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//!!VERERBUNG VON/FÜR GIFTSERVICE NUTZEN

@Service
public class GiftPoolService {

    //wenn Gifts zu aktueller Liste hinzugefügt werden sollen
    private GiftListRepository giftListRepository;

    private GiftsService giftService;


    //ggf. für Programmsteuerung nutzen
    //startService(){ }

        //Standard sorting order by DateOfCreation
        //getAllGifts()

        //if filtering by category
        //getGiftsByCategory

        //addGiftToGiftList

        //createGift

        //deleteGiftFromPool

}
