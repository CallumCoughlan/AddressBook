package com.addressBook.AddressBook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingControllers {

    @Autowired
    private AddBuddyController addBuddyController;

    @Test
    public void addBuddyContextLoads() throws Exception {
        assertThat(addBuddyController).isNotNull();
    }

    @Autowired
    private CreateAddressBookController createAddressBookController;

    @Test
    public void createAddressBookContextLoads() throws Exception {
        assertThat(createAddressBookController).isNotNull();
    }

    @Autowired
    private RemoveBuddyController removeBuddyController;

    @Test
    public void removeBuddyContextLoads() throws Exception {
        assertThat(removeBuddyController).isNotNull();
    }

    @Autowired
    private ShowBuddiesController showBuddiesController;

    @Test
    public void showBuddyContextLoads() throws Exception {
        assertThat(showBuddiesController).isNotNull();
    }
}
