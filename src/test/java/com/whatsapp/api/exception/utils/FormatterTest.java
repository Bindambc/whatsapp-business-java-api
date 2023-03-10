package com.whatsapp.api.exception.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    /**
     * Method under test: {@link Formatter#italic(String)}
     */
    @Test
    void testItalic() {
        assertEquals("_Text_", Formatter.italic("Text"));
    }

    /**
     * Method under test: {@link Formatter#bold(String)}
     */
    @Test
    void testBold() {
        assertEquals("*Text*", Formatter.bold("Text"));
    }

    /**
     * Method under test: {@link Formatter#strikethrough(String)}
     */
    @Test
    void testStrikethrough() {
        assertEquals("~Text~", Formatter.strikethrough("Text"));
    }

    /**
     * Method under test: {@link Formatter#code(String)}
     */
    @Test
    void testCode() {
        assertEquals("```Text```", Formatter.code("Text"));
    }
}

