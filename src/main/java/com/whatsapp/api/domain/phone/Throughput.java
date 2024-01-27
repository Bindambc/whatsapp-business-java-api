package com.whatsapp.api.domain.phone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.phone.type.LevelType;

/**
 * The type Throughput.
 */
@JsonInclude(value = Include.NON_NULL)
public record Throughput(

        @JsonProperty("level") LevelType Level)
{
}