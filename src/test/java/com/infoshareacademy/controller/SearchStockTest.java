package com.infoshareacademy.controller;

import com.infoshareacademy.model.ImportStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchStockTest {


    @Test
    void shouldGetMaxValueWhenFunctionIsCorect() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        SearchStock searchStock = new SearchStock();

        // When
        double maxValueActual = searchStock.printPriceMax(importStock.getResources());
        double maxValueExpected = 1156.73;

        // Then
        assertEquals(maxValueExpected, maxValueActual);
    }

    @Test
    void shouldGetMinValueWhenFunctionIsCorect() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        SearchStock searchStock = new SearchStock();

        // When
        double minValueActual = searchStock.printPriceMin(importStock.getResources());
        double minValueExpected = 963.66;

        // Then
        assertEquals(minValueExpected, minValueActual);
    }
}
