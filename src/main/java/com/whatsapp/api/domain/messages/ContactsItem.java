package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Full contact information.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactsItem {
    /**
     * Optional.
     * <p>
     * YYYY-MM-DD formatted string.
     */
    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("emails")
    private List<EmailsItem> emails;
    /**
     * Optional.
     * <p>
     * Full contact address(es) formatted as an addresses object.
     */
    @JsonProperty("addresses")
    private List<AddressesItem> addresses;

    @JsonProperty("urls")
    private List<UrlsItem> urls;

    @JsonProperty("org")
    private Org org;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("phones")
    private List<PhonesItem> phones;

    public String getBirthday() {
        return birthday;
    }

    public ContactsItem setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public List<EmailsItem> getEmails() {
        return emails;
    }

    public ContactsItem setEmails(List<EmailsItem> emails) {
        this.emails = emails;
        return this;
    }

    public ContactsItem addEmails(EmailsItem emailsItem) {
        if (this.emails == null) this.emails = new ArrayList<>();

        this.emails.add(emailsItem);
        return this;
    }

    public List<AddressesItem> getAddresses() {
        return addresses;
    }

    public ContactsItem setAddresses(List<AddressesItem> addresses) {
        this.addresses = addresses;
        return this;
    }

    public ContactsItem addAddresses(AddressesItem addressesItem) {
        if (this.addresses == null) this.addresses = new ArrayList<>();

        return this;
    }

    public List<UrlsItem> getUrls() {
        return urls;
    }

    public ContactsItem setUrls(List<UrlsItem> urls) {
        this.urls = urls;
        return this;
    }

    public ContactsItem addUrls(UrlsItem urlsItem) {
        if (this.urls == null) this.urls = new ArrayList<>();

        this.urls.add(urlsItem);
        return this;
    }

    public Org getOrg() {
        return org;
    }

    public ContactsItem setOrg(Org org) {
        this.org = org;
        return this;
    }

    public Name getName() {
        return name;
    }

    /**
     * @param name {@link Name}
     */
    public ContactsItem setName(Name name) {
        this.name = name;
        return this;
    }


    public List<PhonesItem> getPhones() {
        return phones;
    }

    /**
     * @param phones {@link PhonesItem}
     */
    public ContactsItem setPhones(List<PhonesItem> phones) {
        this.phones = phones;
        return this;
    }

    public ContactsItem addPhones(PhonesItem phonesItem) {
        if (this.phones == null) this.phones = new ArrayList<>();


        this.phones.add(phonesItem);
        return this;
    }
}