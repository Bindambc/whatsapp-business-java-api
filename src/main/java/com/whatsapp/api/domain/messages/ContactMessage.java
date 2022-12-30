package com.whatsapp.api.domain.messages;

import java.util.ArrayList;
import java.util.List;

/**
 * A contact object
 */
public class ContactMessage {


    private List<ContactsItem> contacts;

    public List<ContactsItem> getContacts() {
        return contacts;
    }

    public ContactMessage setContacts(List<ContactsItem> contacts) {
        this.contacts = contacts;
        return this;
    }

    /**
     * @param contactsItem : Contacts Object.
     *                     <p>
     *                     Add a {@link ContactsItem} object into contacts array.
     */
    public ContactMessage addContacts(ContactsItem contactsItem) {
        if (this.contacts == null) this.contacts = new ArrayList<>();

        this.contacts.add(contactsItem);
        return this;
    }
}