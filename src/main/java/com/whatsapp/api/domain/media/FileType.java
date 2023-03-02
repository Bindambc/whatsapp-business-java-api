package com.whatsapp.api.domain.media;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Supported Media Types
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media#supported-media-types">whatsapp official documentation</a>
 */
public enum FileType {

    /**
     * Jpeg file type.
     */
    JPEG("image/jpeg"),
    /**
     * Png file type.
     */
    PNG("image/png"),


    /**
     * Text file type.
     */
    TEXT("text/plain"),
    /**
     * Pdf file type.
     */
    PDF("application/pdf"),
    /**
     * Ppt file type.
     */
    PPT("application/vnd.ms-powerpoint"),
    /**
     * Doc file type.
     */
    DOC("application/msword"),
    /**
     * Xls file type.
     */
    XLS("application/vnd.ms-excel"),
    /**
     * Docx file type.
     */
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    /**
     * Pptx file type.
     */
    PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation"),
    /**
     * Xlsx file type.
     */
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),


    /**
     * Aac file type.
     */
    AAC("audio/aac"),
    /**
     * Mp 4 file type.
     */
    MP4("audio/mp4"),
    /**
     * Mpeg file type.
     */
    MPEG("audio/mpeg"),
    /**
     * Amr file type.
     */
    AMR("audio/amr"),
    /**
     * Ogg file type.
     */
    OGG("audio/ogg"),
    /**
     * Opus file type.
     */
    OPUS("audio/opus"),


    /**
     * Mp 4 video file type.
     */
    MP4_VIDEO("video/mp4"),
    /**
     * 3gp file type.
     */
    THREEGP("video/3gp"),


    /**
     * Webp file type.
     */
    WEBP("image/webp");

    private final String type;

    FileType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @JsonValue
    public String getType() {
        return type;
    }
}
