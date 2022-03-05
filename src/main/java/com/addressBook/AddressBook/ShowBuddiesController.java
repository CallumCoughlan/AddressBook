package com.addressBook.AddressBook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ShowBuddiesController {

    AddressBookRepository addressBookRepository;
    BuddyInfoRepository buddyInfoRepository;

    List<BuddyInfo> buddyInfoList;

    public ShowBuddiesController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/showBuddies")
    public String showBuddies(@RequestParam(name="addressBookId") long aid, Model model) {
        buddyInfoList = addressBookRepository.findById(aid).getBuddies();
        model.addAttribute("addressBook", buddyInfoList);
        return "buddies";
    }

    @PostMapping("/showBuddies")
    public String showBuddiesSubmit() {
        return "buddies";
    }

    @GetMapping("/getBuddies")
    public void getBuddies1() {

    }

    @PostMapping("/getBuddies")
    public List<BuddyInfo> getBuddies() {
        buddyInfoList = buddyInfoRepository.findAll();
        return buddyInfoList;
    }
}
