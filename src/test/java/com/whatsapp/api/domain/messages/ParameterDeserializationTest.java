package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.api.domain.messages.type.ParameterType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterDeserializationTest {

    @Test
    public void testTextParameterDeserialization() throws Exception {
        String json = "{\"type\":\"text\", \"text\": \"hello\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(TextParameter.class, parameter);
        assertEquals(ParameterType.TEXT, parameter.getType());
    }

    @Test
    public void testCurrencyParameterDeserialization() throws Exception {
        String json = "{\"type\":\"currency\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(CurrencyParameter.class, parameter);
        assertEquals(ParameterType.CURRENCY, parameter.getType());
    }

    @Test
    public void testVideoParameterDeserialization() throws Exception {
        String json = "{\"type\":\"video\", \"video\": {\"id\": \"21\", \"link\": \"http://example.com/video.mp4\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(VideoParameter.class, parameter);
        assertEquals(ParameterType.VIDEO, parameter.getType());
    }

    @Test
    public void testDateTimeParameterDeserialization() throws Exception {
        String json = "{\"type\":\"date_time\", \"date_time\": {\"minute\": \"12\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(DateTimeParameter.class, parameter);
        assertEquals(ParameterType.DATE_TIME, parameter.getType());
    }

    @Test
    public void testImageParameterDeserialization() throws Exception {
        String json = "{\"type\":\"image\", \"image\": {\"id\": \"21\", \"link\": \"http://example.com/image.jpg\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(ImageParameter.class, parameter);
        assertEquals(ParameterType.IMAGE, parameter.getType());
    }

    @Test
    public void testDocumentParameterDeserialization() throws Exception {
        String json = "{\"type\":\"document\", \"document\": {\"id\": \"21\", \"link\": \"http://example.com/document.pdf\", \"filename\":\"hello.doc\" }}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(DocumentParameter.class, parameter);
        assertEquals(ParameterType.DOCUMENT, parameter.getType());
    }

    @Test
    public void testButtonPayloadParameterDeserialization() throws Exception {
        String json = "{\"type\":\"payload\", \"payload\": \"button_payload\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Parameter parameter = objectMapper.readValue(json, Parameter.class);

        assertInstanceOf(ButtonPayloadParameter.class, parameter);
        assertEquals(ParameterType.PAYLOAD, parameter.getType());
    }
}
