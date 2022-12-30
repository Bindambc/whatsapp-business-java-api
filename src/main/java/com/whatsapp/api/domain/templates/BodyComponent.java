package com.whatsapp.api.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyComponent extends Component<BodyComponent> {


    public BodyComponent() {
        super(ComponentType.BODY);
    }


}
