package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;
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
        InputData maxValueWithDate  = searchStock.printPriceMax(importStock.getResources());
        double maxValueActual = maxValueWithDate.getPrice();
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
        InputData minValueWithDate =searchStock.printPriceMin(importStock.getResources());
        double minValueActual = minValueWithDate.getPrice();
        double minValueExpected = 963.66;

        // Then
        assertEquals(minValueExpected, minValueActual);
    }
}
