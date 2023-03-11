package com.whatsapp.api.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FormatterTest {
    /**
     * Method under test: {@link Formatter#italic(String)}
     */
    @Test
    void testItalic() {
        assertEquals("_Text_", Formatter.italic("Text"));
        assertNull(Formatter.italic(null));
        assertEquals("    ", Formatter.italic("    "));
        assertEquals("", Formatter.italic(""));
    }

    /**
     * Method under test: {@link Formatter#bold(String)}
     */
    @Test
    void testBold() {
        assertEquals("*Text*", Formatter.bold("Text"));
        assertNull(Formatter.bold(null));
        assertEquals("    ", Formatter.bold("    "));
        assertEquals("", Formatter.bold(""));
    }

    /**
     * Method under test: {@link Formatter#strikethrough(String)}
     */
    @Test
    void testStrikethrough() {
        assertEquals("~Text~", Formatter.strikethrough("Text"));
        assertNull(Formatter.strikethrough(null));
        assertEquals("    ", Formatter.strikethrough("    "));
        assertEquals("", Formatter.strikethrough(""));
    }

    /**
     * Method under test: {@link Formatter#code(String)}
     */
    @Test
    void testCode() {
        assertEquals("```Text```", Formatter.code("Text"));
        assertNull(Formatter.code(null));
        assertEquals("    ", Formatter.code("    "));
        assertEquals("", Formatter.code(""));
    }
}

