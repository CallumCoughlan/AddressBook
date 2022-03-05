package com.addressBook.AddressBook;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public BuddyInfo(String name, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public BuddyInfo() {
        this.phoneNumber = "";
        this.name = "";
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
        this.phoneNumber = phoneNumber;;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        BuddyInfo buddy = (BuddyInfo) obj;

        return this.name.equals(buddy.getName()) && this.phoneNumber.equals(buddy.getPhoneNumber());
    }

    @Override
    public String toString() {
        return (this.name + " " + this.phoneNumber + " " + this.id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
