package com.whatsapp.api.exception.utils;

/**
 * custom text formatter
 */
public class Formatter {

    /**
     * Italic string.
     *
     * @param text String
     * @return text formatted in italic. Example: <i>"italic text"</i>
     */
    public static String italic(String text) {
        String italic = "_";
        return italic + text + italic;
    }

    /**
     * Bold string.
     *
     * @param text String
     * @return bold formatted text. Example: <b>"bold text"</b>
     */
    public static String bold(String text) {
        String bold = "*";
        return bold + text + bold;
    }

    /**
     * Strikethrough string.
     *
     * @param text String
     * @return strikethrough text. Example: <s>"strikethrough text"</s>
     */
    public static String strikethrough(String text) {
        String strikethrough = "~";
        return strikethrough + text + strikethrough;
    }

    /**
     * Code string.
     *
     * @param text String
     * @return text formatted as code. Example: <code>"code text"</code>
     */
    public static String code(String text) {
        String code = "```";
        return code + text + code;
    }

}
