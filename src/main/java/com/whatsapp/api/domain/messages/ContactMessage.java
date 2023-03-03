package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * A contact object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMessage {


    private List<Contact> contacts;

    /**
     * Gets contacts.
     *
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * Sets contacts.
     *
     * @param contacts the contacts
     * @return the contacts
     */
    public ContactMessage setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    /**
     * Add contacts contact message.
     *
     * @param contact : Contacts Object.                <p>                Add a {@link Contact} object into contacts array.
     * @return the contact message
     */
    public ContactMessage addContacts(Contact contact) {
        if (this.contacts == null) this.contacts = new ArrayList<>();

        this.contacts.add(contact);
        return this;
    }
}