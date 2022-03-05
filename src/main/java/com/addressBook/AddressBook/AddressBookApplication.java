package com.addressBook.AddressBook;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;

@SpringBootApplication
public class AddressBookApplication {

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Bean
    public String demo(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        AddressBook addressBook = new AddressBook("My Address Book");
        addressBook.addBuddy(new BuddyInfo("Jack", "111-111-1111"));
        addressBook.addBuddy(new BuddyInfo("Chloe", "222-222-2222"));
        addressBook.addBuddy(new BuddyInfo("Kim", "333-333-3333"));
        addressBook.addBuddy(new BuddyInfo("David", "444-444-4444"));
        addressBook.addBuddy(new BuddyInfo("Michelle", "555-555-5555"));

        addressBookRepository.save(addressBook);

        return "Done loading";
    }
}
