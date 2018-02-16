package com.infoshareacademy.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PropertyServiceTest {

    @Test
    void shouldParseReadingFromPropertyFile() {
        // Given
        PropertyService propertyService = new PropertyService();

        // When
        String currency = propertyService.getValue("currency");
        String dateFormat = propertyService.getValue("dateFormat");

        // Then
        assertEquals("Dollar", currency);
        assertEquals("yyyy-MM-dd", dateFormat);
    }
}
