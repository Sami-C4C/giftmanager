package de.thb.giftmanager.controller;

import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.exception.GiftNotFoundException;
import de.thb.giftmanager.services.GiftListService;
import de.thb.giftmanager.services.GiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/")
public class GiftsController {

    @Autowired
    private GiftsService giftsService;

    @Autowired
    private GiftListService giftListService;


    @GetMapping("/gifts")
    public String showGiftsPool(Model model) {
        List<Gift> gifts = giftsService.getAllGifts();
        model.addAttribute("gifts", gifts);
        return "gifts";
    }



    @GetMapping("/gifts/new-gift")
    public String creatNewGift(Model model) {
        Gift gift = new Gift();

        List<GiftList> giftLists = giftListService.getAllGiftLists();
        model.addAttribute("gift", gift);
        model.addAttribute("pageTitle", "Create New Gift");
        model.addAttribute("giftLists", giftLists);
        return "new-gift";
    }


    @PostMapping("/gifts/save")
    public String saveGift(Gift gift, RedirectAttributes redirectAttributes) {
        giftsService.saveGift(gift);
        redirectAttributes.addFlashAttribute("success", "Gift is saved successfully.");
        return "redirect:/gifts";
    }


    @GetMapping("/gifts/edit/{id}")
    public String editGift(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {

            Gift gift = giftsService.getGift(id);
            model.addAttribute("gift", gift);
            model.addAttribute("pageTitle", "Edit Gift ==>[ID: " + id + "]");
            model.addAttribute("giftLists", gift.getGiftList());
            return "new-gift";
        } catch (GiftNotFoundException ex) {
            redirectAttributes.addFlashAttribute("success", ex.getMessage());
            return "redirect:/gifts";
        }
    }


    @GetMapping("/gifts/delete/{id}")
    public String deleteGift(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            giftsService.deleteGift(id);
            redirectAttributes.addFlashAttribute("success", "Gift with ID " + id + " is deleted successfully");

        } catch (GiftNotFoundException ex) {
            redirectAttributes.addFlashAttribute("success", ex.getMessage());
        }
        return "redirect:/gifts";

    }



    @GetMapping("gifts/{id}")
    public String showGiftsDetails(@PathVariable("id") Long id, Model model) {


        Gift gift = giftsService.getGiftByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("gift", gift);


        return "gift_details";
    }



}
