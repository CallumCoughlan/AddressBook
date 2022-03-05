package com.addressBook.AddressBook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

class AddBuddyRequest {
    private long addressBookId;
    private String name;
    private String phoneNumber;

    public long getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(long addressBookId) {
        this.addressBookId = addressBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

@RestController
public class AddBuddyRestController {

    private BuddyInfoRepository buddyInfoRepository;
    private AddressBookRepository addressBookRepository;

    public AddBuddyRestController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addBuddyRest")
    public String addBuddyForm(@RequestParam(name="addressBookId") long aid, @RequestParam(name="name") String name, @RequestParam(name="phoneNumber") String phoneNumber, Model model) {
        model.addAttribute("buddy", new BuddyInfo(name, phoneNumber));
        model.addAttribute("addressBookId", addressBookRepository.findById(aid));
        return "addBuddyRest";
    }

    @PostMapping("/addBuddyRest")
    public void addBuddySubmit(@RequestBody AddBuddyRequest addBuddyRequest) {
        AddressBook addressBook = addressBookRepository.findById(addBuddyRequest.getAddressBookId());
        addressBook.addBuddy(new BuddyInfo(addBuddyRequest.getName(), addBuddyRequest.getPhoneNumber()));
        addressBookRepository.save(addressBook);
    }
}
