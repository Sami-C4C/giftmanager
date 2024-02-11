package de.thb.giftmanager.controller;

import de.thb.giftmanager.controller.form.GiftListForm;
import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.entity.GiftList;
import de.thb.giftmanager.services.GiftListService;
import de.thb.giftmanager.services.GiftsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GiftListController {

    @Autowired
    private GiftListService giftListService;




    // App: All my lists
    @GetMapping("giftlists")
    public String getAllGiftLists(Model model) {
        model.addAttribute("giftlists", giftListService.getAllGiftLists());
        return "giftlists";
    }

    //Set event as standard sorting order in MyLists-View (Service --> Repository findAllOrderedByEvent())
    /*@GetMapping(~"mylists")
    public String getAllGiftListsSorted(Model model) { }
    */


    //App: Gift list details
    @GetMapping("giftlists/{id}")
    public String showGiftListDetails(@PathVariable("id") Long id, Model model) {
        GiftList giftlist = giftListService.getGiftListByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("giftlist", giftlist);

        return "details";
    }



    // return confirmation message with successfully adding.
    @PostMapping("/giftlists/new-list")
    public RedirectView addGiftList(GiftListForm form, RedirectAttributes redirectAttributes) {
        giftListService.addGiftList(form.getTitle(), form.getEvent(), form.getDueDate(), form.getTotalPrice());

        redirectAttributes.addFlashAttribute("success", "Giftlist successfully created.");

        return new RedirectView("/giftlists");
    }




    @GetMapping("/giftlists/new-list")
    public String createNewGiftList(Model model){
        GiftList giftList = new GiftList();
        model.addAttribute("giftlist",giftList);
        return "new-list";
    }







}
