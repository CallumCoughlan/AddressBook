package com.addressBook.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RemoveBuddyController {

    private BuddyInfoRepository buddyInfoRepository;

    public RemoveBuddyController(BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/removeBuddy")
    public String removeBuddyForm(Model model) {
        long bid = 0;
        model.addAttribute("removeBuddy", bid);
        return "removeBuddy";
    }

    @PostMapping("/removeBuddy")
    public void removeBuddySubmit(@ModelAttribute long bid) {
        buddyInfoRepository.removeBuddyInfoById(bid);
    }
}
