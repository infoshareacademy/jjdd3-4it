package com.infoshareacademy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class ImportStockTest {

    @Test
    void readFromFileWhenFileNameIsInvalidShouldReturnEmptyResourceSize() {
        // Given
        String pathToFile = "src/test/resources/bitcoinxxx.csv";
        ImportStock importStock = new ImportStock(pathToFile);

        // When
        importStock.readFromFile();
        Integer actualResourceSize = importStock.getResources().size();
        Integer expectedResourceSize = 0;

        // Then
        assertEquals(expectedResourceSize, actualResourceSize);
    }


    @Test
    void shouldParseReadingFromCSVFile() {
        // Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);

        // When
        importStock.readFromFile();
        InputData inputData = importStock.getResources().get(1);
        Double actualPrice = inputData.getPrice();
        LocalDate actualDate = inputData.getDate();
        LocalDate expectedDate = LocalDate.parse("2017-01-02");

        // Then
        assertEquals(998.62, (double) actualPrice);
        assertEquals(expectedDate, actualDate);
    }
}
