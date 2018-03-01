package com.infoshareacademy.controller;

import com.infoshareacademy.model.ImportStock;
import com.infoshareacademy.model.InputData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
     void shouldGetMedianWhenFunctionIsCorect(){

         //Given
         String pathToFile = "src/test/resources/bitCoin.csv";
         ImportStock importStock = new ImportStock(pathToFile);
         importStock.readFromFile();
         MathStock mathStock = new MathStock();

         // When
         double medianActual = mathStock.medianPriceForRange(mathStock.listHelp);
         double medianExpected = 1033;

         // Then
         assertEquals(medianExpected, medianActual);

     }







}