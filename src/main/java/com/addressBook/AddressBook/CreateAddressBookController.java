package com.addressBook.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateAddressBookController {

    private AddressBookRepository addressBookRepository;

    public CreateAddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addAddressBook")
    public String addAddressBookForm(Model model) {
        model.addAttribute("addAddressBook", new AddressBook());
        return "addAddressBook";
    }

    @PostMapping("/addAddressBook")
    public void addAddressBookSubmit(@ModelAttribute AddressBook addressBook) {
        addressBookRepository.save(addressBook);
    }
}
