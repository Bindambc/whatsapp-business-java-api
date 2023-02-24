package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Full contact information.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    /**
     * Optional.
     * <p>
     * YYYY-MM-DD formatted string.
     */
    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("emails")
    private List<Email> emails;
    /**
     * Optional.
     * <p>
     * Full contact address(es) formatted as an addresses object.
     */
    @JsonProperty("addresses")
    private List<Address> addresses;

    @JsonProperty("urls")
    private List<Url> urls;

    @JsonProperty("org")
    private Org org;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("phones")
    private List<Phone> phones;

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     * @return the birthday
     */
    public Contact setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * Gets emails.
     *
     * @return the emails
     */
    public List<Email> getEmails() {
        return emails;
    }

    /**
     * Sets emails.
     *
     * @param emails the emails
     * @return the emails
     */
    public Contact setEmails(List<Email> emails) {
        this.emails = emails;
        return this;
    }

    /**
     * Add emails contact.
     *
     * @param email the email
     * @return the contact
     */
    public Contact addEmails(Email email) {
        if (this.emails == null) this.emails = new ArrayList<>();

        this.emails.add(email);
        return this;
    }

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     * @return the addresses
     */
    public Contact setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    /**
     * Add addresses contact.
     *
     * @param address the address
     * @return the contact
     */
    public Contact addAddresses(Address address) {
        if (this.addresses == null) this.addresses = new ArrayList<>();

        return this;
    }

    /**
     * Gets urls.
     *
     * @return the urls
     */
    public List<Url> getUrls() {
        return urls;
    }

    /**
     * Sets urls.
     *
     * @param urls the urls
     * @return the urls
     */
    public Contact setUrls(List<Url> urls) {
        this.urls = urls;
        return this;
    }

    /**
     * Add urls contact.
     *
     * @param url the url
     * @return the contact
     */
    public Contact addUrls(Url url) {
        if (this.urls == null) this.urls = new ArrayList<>();

        this.urls.add(url);
        return this;
    }

    /**
     * Gets org.
     *
     * @return the org
     */
    public Org getOrg() {
        return org;
    }

    /**
     * Sets org.
     *
     * @param org the org
     * @return the org
     */
    public Contact setOrg(Org org) {
        this.org = org;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name {@link Name}
     * @return the name
     */
    public Contact setName(Name name) {
        this.name = name;
        return this;
    }


    /**
     * Gets phones.
     *
     * @return the phones
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * Sets phones.
     *
     * @param phones {@link Phone}
     * @return the phones
     */
    public Contact setPhones(List<Phone> phones) {
        this.phones = phones;
        return this;
    }

    /**
     * Add phones contact.
     *
     * @param phone the phone
     * @return the contact
     */
    public Contact addPhones(Phone phone) {
        if (this.phones == null) this.phones = new ArrayList<>();


        this.phones.add(phone);
        return this;
    }
}