package de.thb.giftmanager.api2;

import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.services.GiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// OSAMA Version API Controller

@RestController
@RequestMapping("/gma/api/v1")
public class GiftsControllerREST {

    @Autowired
    private GiftsService giftsService;

    /*
    // To get all gifts , that saved unter specific giftList
    @GetMapping("/giftlist/{giftListId}/gifts")
    public List<Gift> getGiftList(@PathVariable long giftListId) {
        return giftsService.getGiftList(giftListId);
    }

    @GetMapping("/gift")
    public List<Gift> getAllGifts(long id) {
        return giftsService.getAllGifts(id);
    }

    @GetMapping("/getGiftByID")
    public Gift getGiftByID(@RequestParam long id) {
        return giftsService.getGiftByID(id);
    }

    @GetMapping("/getGiftByTitle")
    public List<Gift> getGiftByTitle(@RequestParam String title) {
        return giftsService.getGiftByTitle(title);
    }

    // return confirmation message with successfully adding.
    @PostMapping("/gift")
    public String addGift(@RequestBody Gift newGift) {
        giftsService.addGift(newGift);
        return "saved successfully";
    }

    @PutMapping("/gift")
    public String updateGift(@RequestBody Gift newGift) {
        giftsService.updateGift(newGift);
        return "update successfully";
    }

    @DeleteMapping("/gift")
    public String deleteGift(@RequestParam long id) {
        giftsService.deleteGift(id);
        return "Delete Successfully";

    }
    */

}
