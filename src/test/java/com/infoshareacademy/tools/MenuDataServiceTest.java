package com.infoshareacademy.tools;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MenuDataServiceTest {

    @Test
    void shouldReadIntegerValue() {
        //Given
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));

        //When
        Integer actual = MenuDataService.checkNumerCorrectFormat();

        //Then
        assertEquals(10, actual.intValue());
    }

    @Test
    void shouldReadIntegerValueInRange() {
        //Given
        List<String> list = Arrays.asList("one", "two", "three");
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));

        //When
        int actual = MenuDataService.getMenuValue(list);
        //Then
        assertEquals(2, actual);
    }

}
