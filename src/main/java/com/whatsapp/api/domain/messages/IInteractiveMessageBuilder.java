package com.whatsapp.api.domain.messages;

public interface IInteractiveMessageBuilder {

    interface IInteractiveAction {
        IInteractiveType setAction(Action action);
    }

    interface IInteractiveType {
        InteractiveMessage setType(InteractiveMessageType type);
    }

}
