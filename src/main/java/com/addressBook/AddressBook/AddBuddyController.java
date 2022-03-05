package com.addressBook.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddBuddyController {

    private BuddyInfoRepository buddyInfoRepository;
    private AddressBookRepository addressBookRepository;

    public AddBuddyController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addBuddy")
    public String addBuddyForm(Model model) {
        long aid = 0;
        model.addAttribute("addBuddy", new BuddyInfo());
        model.addAttribute("addressBook", aid);
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public String addBuddySubmit(@ModelAttribute long aid, @ModelAttribute BuddyInfo buddyInfo) {
        addressBookRepository.findById(aid).addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        return "addBuddy";
    }

    @GetMapping("/SPA")
    public String SPA() {
        return "SPA";
    }

    @PostMapping("/SPA")
    public void SPASubmit() {
    }
}
