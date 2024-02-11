package de.thb.giftmanager.controller;

import de.thb.giftmanager.entity.Gift;
import de.thb.giftmanager.services.GiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class GiftsController {

    @Autowired
    private GiftsService giftsService;

    @RequestMapping("/giftmanager")
    public String viewHomePage(){

        return "index";
    }


    @GetMapping("/gifts")
    public String showGiftsPool(Model model){
        List<Gift> gifts = giftsService.getAllGifts();
        model.addAttribute("gifts", gifts);
        return "gifts";
    }



/*    @GetMapping("/gifts")
    public String showGiftPoolGifts(Model model) {
        model.addAttribute("gifts", giftsService.getAllGifts());
        return "gifts";
    }*/


    @GetMapping("/gifts/new-gift")
    public String creatNewGift(Model model){
        Gift gift = new Gift();
        model.addAttribute("gift",gift);
        return "new-gift";
    }

    @PostMapping("/gifts/save")
    public String saveGift(Gift gift, RedirectAttributes redirectAttributes){
       giftsService.saveGift(gift);
       redirectAttributes.addFlashAttribute("message","Gift saved successfully.");
       return "redirect:/gifts";
    }

/**
    @PostMapping( "gifts/save")
    public RedirectView saveNewGift(@ModelAttribute("gifts") Gift gift) {

        giftsService.saveGift(gift);
        return new RedirectView("/gifts");
    }
 */

    @RequestMapping("/edit/{id}")
    public ModelAndView showGiftAfterEditing(@PathVariable (name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_gift");
        Gift gift = giftsService.get(id);
        modelAndView.addObject("gift",gift);
        return modelAndView;
    }



    //App: Giftpool


 /**
    @GetMapping("gifts/{id}")
    public String showGiftListDetails(@PathVariable("id") Long id, Model model) {
        Gift gift = giftsService.getGiftByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("gift", gift);

        return "gift_details";
    }
    */

    /**
    @PostMapping("gifts")
    public RedirectView addGift(GiftForm form, RedirectAttributes redirectAttributes) {
        giftsService.addGift(form.getTitle(), form.getCategory(), form.getEan(), form.getPrice(), form.getLink(), form.getDateOfCreation());

        redirectAttributes.addFlashAttribute("success", "Gift successfully created.");

        return new RedirectView("/gifts");
    }
    **/



}
