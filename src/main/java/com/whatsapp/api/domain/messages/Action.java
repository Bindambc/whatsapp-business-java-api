
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
    private String button;
    @JsonProperty("buttons")
    private List<Button> buttons;
    @JsonProperty("sections")
    private List<Section> sections;

    public String getCatalogId() {
        return catalogId;
    }

    public Action setCatalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    public String getProductRetailerId() {
        return productRetailerId;
    }

    public Action setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }

    public String getButton() {
        return button;
    }

    public Action setButton(String button) {
        this.button = button;
        return this;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Action setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public Action addButton(Button button) {
        if (this.buttons == null)
            this.buttons = new ArrayList<>();

        this.buttons.add(button);
        return this;
    }

    public List<Section> getSections() {
        return sections;
    }

    public Action setSections(List<Section> sections) {
        this.sections = sections;
        return this;
    }

    public Action addSection(Section section) {
        if (this.sections == null)
            this.sections = new ArrayList<>();

        this.sections.add(section);
        return this;
    }
}
