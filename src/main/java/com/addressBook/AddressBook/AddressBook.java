package com.addressBook.AddressBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private String name;

    @OneToMany(targetEntity=BuddyInfo.class, cascade=CascadeType.ALL)
    List<BuddyInfo> buddies;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public AddressBook(String name) {
        this.buddies = new ArrayList<>();
        this.name = name;
    }

    public AddressBook() {

    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        this.buddies.remove(buddy);
    }

    @Override
    public String toString() {
        StringBuilder buddyList = new StringBuilder();
        for(BuddyInfo buddy: this.buddies) {
            buddyList.append(buddy.toString() + "\n");
        }
        return buddyList.toString();
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return id;
    }
}
