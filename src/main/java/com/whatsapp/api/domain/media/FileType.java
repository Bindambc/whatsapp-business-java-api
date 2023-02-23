package com.whatsapp.api.domain.media;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FileType {
    // Options for images
    JPEG("image/jpeg"), PNG("image/png"),

    // Options for documents
    TEXT("text/plain"), PDF("application/pdf"), PPT("application/vnd.ms-powerpoint"), DOC("application/msword"), XLS("application/vnd.ms-excel"), DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"), PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation"), XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),

    // Options for audio
    AAC("audio/aac"), MP4("audio/mp4"), MPEG("audio/mpeg"), AMR("audio/amr"), OGG("audio/ogg"), OPUS("audio/opus"),

    // Options for video
    MP4_VIDEO("video/mp4"), THREEGP("video/3gp"),

    // Options for stickers
    WEBP("image/webp");

    private final String type;

    FileType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
