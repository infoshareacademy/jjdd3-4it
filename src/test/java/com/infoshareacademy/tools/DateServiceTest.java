package com.infoshareacademy.tools;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateServiceTest {

    @Test
    void shouldParseCorrectDate() {
        // Given
        LocalDate expected = LocalDate.of(2018, 1, 1);

        // When
        LocalDate actual = DateService.dateInRange("2018-01-01");

        // Then
        assertEquals(actual, expected);
    }

    @Test
    void shouldThrowsWhenRangeIsWrong() {
        // Then
        assertThrows(DateTimeException.class, ()->DateService.dateInRange("2018-02-31"));
    }

    @Test
    void shouldGetDateWhenFormatIsCorrect() {
        // Given
        LocalDate expected = LocalDate.of(2018, 1, 1);

        // When
        LocalDate actual = DateService.dateCorrectFormat(LocalDate.parse("2018-01-01"));

        // Then
        assertEquals(actual, expected);
    }

    @Test
    void shouldThrowsWhenFormatWrong() {
        // Then
        assertThrows(DateTimeException.class, ()->DateService.dateCorrectFormat(LocalDate.parse("2018/02/02")));
    }
}