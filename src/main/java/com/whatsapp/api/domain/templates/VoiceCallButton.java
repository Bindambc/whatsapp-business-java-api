package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.whatsapp.api.domain.templates.type.ButtonType;

/**
 * The type Voice call button.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoiceCallButton extends Button {

  /**
   * Instantiates a new Voice call button.
   */
  protected VoiceCallButton() {
    super(ButtonType.VOICE_CALL);
  }

  /**
   * Instantiates a new Quick reply button.
   *
   * @param text the text
   */
  public VoiceCallButton(String text) {
    super(ButtonType.VOICE_CALL, text);
  }
}
