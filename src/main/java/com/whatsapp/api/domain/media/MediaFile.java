package com.whatsapp.api.domain.media;

/**
 * @param fileName file name
 * @param content  file content
 */
public record MediaFile(String fileName, byte[] content) {
}
