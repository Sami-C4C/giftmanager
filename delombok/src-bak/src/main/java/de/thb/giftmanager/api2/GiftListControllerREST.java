package de.thb.giftmanager.api2;

import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.services.GiftListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// OSAMA Version API Controller

@RestController
@RequestMapping("/gma/api/v1")
public class GiftListControllerREST {

    @Autowired
    private GiftListService giftListService;

    /*

    @GetMapping("/giftlist")
    public List<GiftList> getAllGiftLists(long id) {
        return giftListService.getAllGiftLists(id);
    }

    @GetMapping("/getGiftListByID")
    public GiftList getGiftListByID(@RequestParam long id) {
        return giftListService.getGiftListByID(id);
    }


    @GetMapping("/getGiftListByTitle")
    public List<GiftList> getGiftListByTitle(@RequestParam String title) {
        return giftListService.getGiftListByTitle(title);
    }



    //return confirmation message with successfully adding.
    @PostMapping("/giftlist")
    public String addGiftList(@RequestBody GiftList newGiftList) {
        giftListService.addGiftList(newGiftList);
        return "saved successfully";
    }


    @PutMapping("/giftlist")
    public String updateGiftList(@RequestBody GiftList newGiftList) {
        giftListService.updateGiftList(newGiftList);
        return "update successfully";
    }

    @DeleteMapping("/giftlist")
    public String deleteGiftList(@RequestParam long id) {
        giftListService.deleteGiftList(id);
        return "Delete Successfully";

    }

 */
}
