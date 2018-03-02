package com.infoshareacademy.tools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.ThreadPoolExecutor;

public class InputReaderServiceTest {


    @Test
    void shouldReadStringValue() {
        //Given
        System.setIn(new ByteArrayInputStream("10.0\n".getBytes()));

        //When
        String actual = InputReaderService.read();

        //Then
        assertEquals("10.0", actual);
    }

    @Test
    void shountNotReadTwoStringValue() {
        //Given
        System.setIn(new ByteArrayInputStream("10.0\n 12.0\n".getBytes()));

        //When
        String actualFirstValue = InputReaderService.read();
        String actualSecondValue = InputReaderService.read();

        //Then
        assertEquals("10.0", actualFirstValue);
        assertNull(actualSecondValue);
    }

    @Test
    void shouldReadIntegerValue() {
        //Given
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));

        //When
        Integer actual = InputReaderService.readInt();

        //Then
        assertEquals(10, actual.intValue());
    }

    @Test
    void shouldThrowExeptionWhenValueIsNotInteger() {
        //Given
        System.setIn(new ByteArrayInputStream(("test\n").getBytes()));

        //When
        Throwable exeption = assertThrows(NumberFormatException.class, () -> {
            InputReaderService.readInt();
        });

        //Then
        assertTrue(exeption instanceof NumberFormatException);
    }
}
