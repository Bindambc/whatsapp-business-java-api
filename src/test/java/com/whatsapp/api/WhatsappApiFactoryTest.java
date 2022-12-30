package com.whatsapp.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhatsappApiFactoryTest {


    /**
     * Method under test: {@link WhatsappApiFactory#newInstance(String)}
     */
    @Test
    void testNewInstance() {
        assertEquals("Api Key", WhatsappApiFactory.newInstance("Api Key").token);
    }

    /**
     * Method under test: {@link WhatsappApiFactory#newBusinessCloudApi()}
     */
    @Test
    void testNewBusinessCloudApi() {

        var wapi = WhatsappApiFactory.newInstance("Api Key").newBusinessCloudApi();

        Assertions.assertNotNull(wapi);

    }

    /**
     * Method under test: {@link WhatsappApiFactory#newBusinessManagementApi()}
     */
    @Test
    void testNewBusinessManagementApi() {

        var wapi = WhatsappApiFactory.newInstance("Api Key").newBusinessManagementApi();

        Assertions.assertNotNull(wapi);
    }
}

