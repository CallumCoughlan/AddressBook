package com.addressBook.AddressBook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

class RemoveBuddyRequest {
    private long buddyId;

    private long addressBookId;

    public long getBuddyId() {
        return this.buddyId;
    }

    public long getAddressBookId() {
        return this.addressBookId;
    }
}

@RestController
public class RemoveBuddyRestController {

    private BuddyInfoRepository buddyInfoRepository;
    private AddressBookRepository addressBookRepository;

    public RemoveBuddyRestController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/removeBuddyRest")
    public String removeBuddyForm(@RequestParam(name="buddyId") long bid, Model model) {
        model.addAttribute("buddy", buddyInfoRepository.findById(bid));
        return "removeBuddyRest";
    }

    @PostMapping("/removeBuddyRest")
    public void removeBuddySubmit(@RequestBody RemoveBuddyRequest removeBuddyRequest) {
        AddressBook addressBook = addressBookRepository.findById(removeBuddyRequest.getAddressBookId());
        addressBook.removeBuddy(buddyInfoRepository.findById(removeBuddyRequest.getBuddyId()));
        addressBookRepository.save(addressBook);
    }
}
