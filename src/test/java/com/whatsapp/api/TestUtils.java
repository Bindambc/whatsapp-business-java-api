package com.whatsapp.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class TestUtils {


    /**
     * @return String with file contents
     */
    public String fromResource(String fileName) throws IOException, URISyntaxException {

        byte[] encoded = Files.readAllBytes(Paths.get(Objects.requireNonNull(this.getClass() //
                .getResource(fileName)).toURI()));
        return new String(encoded, StandardCharsets.UTF_8);


    }

    /**
     * @return byte[] with file contents
     */
    public byte[] bytesFromResource(String fileName) throws IOException, URISyntaxException {

        return Files.readAllBytes(Paths.get(Objects.requireNonNull(this.getClass() //
                .getResource(fileName)).toURI()));


    }
}
