package de.thb.giftmanager.controller;

import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.exception.GiftListNotFoundException;
import de.thb.giftmanager.services.GiftListService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GiftListController {

    @Autowired
    private GiftListService giftListService;


    @GetMapping("/giftlists")
    public String getAllGiftLists(Model model) {
        List<GiftList> giftLists = giftListService.getAllGiftLists();
        model.addAttribute("giftlists", giftLists);
        return "giftlists";
    }

    @GetMapping("giftlists/{id}")
    public String showGiftListDetails(@PathVariable("id") Long id, Model model) {
        GiftList giftlist = giftListService.getGiftListByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("giftlist", giftlist);

        List<Gift> gifts = giftlist.getGifts();
        model.addAttribute("gifts", gifts);

        return "list_details";
    }


    @GetMapping("/giftlists/new-list")
    public String creatNewGiftList(Model model) {
        GiftList giftList = new GiftList();
        model.addAttribute("giftlist", giftList);
        model.addAttribute("pageTitle", "Create New GiftList");
        return "new-list";
    }

    @PostMapping("/giftlists/save")
    public String saveGiftList(GiftList giftList, RedirectAttributes redirectAttributes) {
        giftListService.saveGiftList(giftList);

        redirectAttributes.addFlashAttribute("success", "Giftlist is saved successfully.");
        return "redirect:/giftlists";
    }

    @GetMapping("/giftlists/edit/{id}")
    public String editGiftList(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            GiftList giftList = giftListService.getGiftList(id);
            model.addAttribute("giftlist", giftList);
            model.addAttribute("pageTitle", "Edit GiftList ==>[ID: " + id + "]");
            return "new-list";
        } catch (GiftListNotFoundException ex) {
            redirectAttributes.addFlashAttribute("success", ex.getMessage());
            return "redirect:/giftlists";
        }
    }


    @GetMapping("/giftlists/delete/{id}")
    public String deleteGiftList(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            giftListService.deleteGiftList(id);
            redirectAttributes.addFlashAttribute("success", "GiftList with ID " + id + " is deleted successfully");

        } catch (GiftListNotFoundException ex) {
            redirectAttributes.addFlashAttribute("success", ex.getMessage());
        }
        return "redirect:/giftlists";

    }


}
