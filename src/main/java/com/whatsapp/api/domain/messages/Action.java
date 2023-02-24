package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 *  <li> <p> <b>button</b> - Required for List Messages - It cannot be an empty string and must be unique within the message.
 *  Emojis are supported, markdown is not. Maximum length: 20 characters</p></li>
 *
 *  <li> <p> <b>buttons</b> - Required for Reply Buttons - A button object can contain the following parameters:</p>
 *      <ul>
 *         <li><p><b>type:</b> only supported type is reply (for Reply Button)</p>
 *         <li><p><b>title:</b> Button title. It cannot be an empty string and must be unique within the message. Emojis are supported, markdown is not. Maximum length: 20 characters.</p>
 *         <li><p><b>id:</b> Unique identifier for your button. This ID is returned in the webhook when the button is clicked by the user. Maximum length: 256 characters.</p>
 *      </ul>
 *       <p>You can have up to 3 buttons. You cannot have leading or trailing spaces when setting the ID.</p></li>
 *
 *  <li> <b>catalog_id</b> - Required for Single Product Messages and Multi-Product Messages - Unique identifier of the
 *  Facebook catalog linked to your WhatsApp Business Account. This ID can be retrieved via the Meta Commerce Manager.</li>
 *
 *  <li> <b>product_retailer_id</b> - Required for Single Product Messages and Multi-Product Messages - Unique identifier of the product in a catalog.
 *      <p> To get this ID go to Meta Commerce Manager and select your Meta Business account. You will see a list of shops connected to your account.
 *      Click the shop you want to use. On the left-side panel, click Catalog > Items, and find the item you want to mention.
 *      The ID for that item is displayed under the item's name.</li>
 *
 *  <li> <b>sections</b> - Required for List Messages and Multi-Product Messages - Array of section objects. Minimum of 1, maximum of 10. See section object.</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {

    @JsonProperty("catalog_id")
    private String catalogId;
    @JsonProperty("product_retailer_id")
    private String productRetailerId;
    @JsonProperty("button")
    private String buttonText;
    @JsonProperty("buttons")
    private List<Button> buttons;
    @JsonProperty("sections")
    private List<Section> sections;

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * Sets catalog id.
     *
     * @param catalogId Required for Single Product Messages and Multi-Product Messages - Unique identifier of the                  Facebook catalog linked to your WhatsApp Business Account. This ID can be retrieved via the Meta Commerce Manager.
     * @return the catalog id
     */
    public Action setCatalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Gets product retailer id.
     *
     * @return the product retailer id
     */
    public String getProductRetailerId() {
        return productRetailerId;
    }

    /**
     * Sets product retailer id.
     *
     * @param productRetailerId the product retailer id
     * @return the product retailer id
     */
    public Action setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }

    /**
     * Gets button text.
     *
     * @return the button text
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * Sets button text.
     *
     * @param buttonText the button text
     * @return the button text
     */
    public Action setButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    /**
     * Gets buttons.
     *
     * @return the buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * Sets buttons.
     *
     * @param buttons the buttons
     * @return the buttons
     */
    public Action setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * Add button action.
     *
     * @param button the type {@link Button}
     * @return the action
     */
    public Action addButton(Button button) {
        if (this.buttons == null) this.buttons = new ArrayList<>();

        this.buttons.add(button);
        return this;
    }

    /**
     * Gets sections.
     *
     * @return the sections
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Sets sections.
     *
     * @param sections List of @{@link Section}
     * @return the sections
     */
    public Action setSections(List<Section> sections) {
        this.sections = sections;
        return this;
    }

    /**
     * Add section action.
     *
     * @param section the section
     * @return the action
     */
    public Action addSection(Section section) {
        if (this.sections == null) this.sections = new ArrayList<>();

        this.sections.add(section);
        return this;
    }
}
