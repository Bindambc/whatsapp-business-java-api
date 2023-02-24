package com.whatsapp.api.domain.messages.builder;

import com.whatsapp.api.domain.messages.Action;
import com.whatsapp.api.domain.messages.InteractiveMessage;
import com.whatsapp.api.domain.messages.type.InteractiveMessageType;

public interface IInteractiveMessageBuilder {

    interface IInteractiveAction {
        IInteractiveType setAction(Action action);
    }

    interface IInteractiveType {
        InteractiveMessage setType(InteractiveMessageType type);
    }

}
