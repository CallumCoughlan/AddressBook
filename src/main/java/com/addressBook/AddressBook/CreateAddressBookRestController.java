package com.addressBook.AddressBook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

class AddAddressBookRequest {
    private String name;

    public String getAddressBookName() {
        return this.name;
    }
}

@RestController
public class CreateAddressBookRestController {

    private AddressBookRepository addressBookRepository;

    public CreateAddressBookRestController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addAddressBookRest")
    public String addAddressBookForm(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("addressBook", new AddressBook(name));
        return "addressBook";
    }

    @PostMapping("/addAddressBookRest")
    public void addAddressBookSubmit(@RequestBody AddAddressBookRequest addAddressBookRequest) {
        AddressBook addressBook = new AddressBook(addAddressBookRequest.getAddressBookName());
        addressBookRepository.save(addressBook);
    }
}
