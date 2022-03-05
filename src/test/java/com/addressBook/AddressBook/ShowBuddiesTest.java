package com.addressBook.AddressBook;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ShowBuddiesTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showBuddyTest() throws Exception {
        this.mockMvc.perform(post("/showBuddies")).andExpect(status().isOk())
                .andExpect(content().string(containsString("buddies")));
    }
}
