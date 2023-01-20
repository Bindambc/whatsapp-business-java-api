package com.whatsapp.api.domain.messages;

import java.util.ArrayList;
import java.util.List;

/**
 * A contact object
 */
public class ContactMessage {


    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public ContactMessage setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    /**
     * @param contact : Contacts Object.
     *                     <p>
     *                     Add a {@link Contact} object into contacts array.
     */
    public ContactMessage addContacts(Contact contact) {
        if (this.contacts == null) this.contacts = new ArrayList<>();

        this.contacts.add(contact);
        return this;
    }
}