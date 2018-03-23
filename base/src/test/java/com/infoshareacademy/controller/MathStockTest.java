package com.infoshareacademy.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathStockTest {


    @Test
    void shouldGetAverageWhenFunctionIsCorect() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        MathStock mathStock = new MathStock();

        // When
        double averageActual = mathStock.averagePriceForRange(importStock.getResources());
        double averageExpected = 1033.2083333333333;

        // Then
        assertEquals(averageExpected, averageActual);
    }

    @Test
    void shouldGetMedianWhenFunctionIsCorectForOddValue() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        importStock.getResources().remove(5);

        MathStock mathStock = new MathStock();

        // When
        double medianActual = mathStock.medianPriceForRange(importStock.getResources());
        double medianExpected = 1021.6;

        // Then
        assertEquals(medianExpected, medianActual);
    }

    @Test
    void shouldGetMedianWhenFunctionIsCorectForEvenValue() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        MathStock mathStock = new MathStock();

        // When
        double medianActual = mathStock.medianPriceForRange(importStock.getResources());
        double medianExpected = 1017.9200000000001;

        // Then
        assertEquals(medianExpected, medianActual);
    }

    @Test
    void shouldGetMovingAverageWhenFunctionIsCorect() {

        //Given
        String pathToFile = "src/test/resources/bitCoin.csv";
        ImportStock importStock = new ImportStock(pathToFile);
        importStock.readFromFile();
        MathStock mathStock = new MathStock();

        // When
        double movingAverageActual1 = mathStock.movingAveragePriceForRange(importStock.getResources()).get(0);
        double movingAverageActual2 = mathStock.movingAveragePriceForRange(importStock.getResources()).get(1);
        double movingAverageActual3 = mathStock.movingAveragePriceForRange(importStock.getResources()).get(2);
        double movingAverageExpected1 = 1007.07;
        double movingAverageExpected2 = 1055.3375;
        double movingAverageExpected3 = 1059.2425;

        // Then
        assertEquals(movingAverageExpected1, movingAverageActual1);
        assertEquals(movingAverageExpected2, movingAverageActual2);
        assertEquals(movingAverageExpected3, movingAverageActual3);
    }
}