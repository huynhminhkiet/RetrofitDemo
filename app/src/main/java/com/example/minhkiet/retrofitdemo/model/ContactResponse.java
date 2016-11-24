package com.example.minhkiet.retrofitdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhkiet on 21/11/2016
 */

public class ContactResponse {
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     *
     * @return
     *     The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     *     The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
