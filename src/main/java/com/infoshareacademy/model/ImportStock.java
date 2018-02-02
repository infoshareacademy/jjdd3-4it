package com.infoshareacademy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportStock {
    String sourceFile = "src/main/resources/bitcoin.csv";
    
    File file = new File(sourceFile);

    List<String> date = new ArrayList<>();
    List<String> txVolumeUSD = new ArrayList<>();
    List<String> txCount = new ArrayList<>();
    List<String> marketCupUSD = new ArrayList<>();
    List<String> priceUSD = new ArrayList<>();
    List<String> exchangeVolumeUSD = new ArrayList<>();
    List<String> generatedCoins = new ArrayList<>();
    List<String> fees = new ArrayList<>();

    public void readFromFile() {
        try (Scanner inputStream = new Scanner(file)) {
            if (inputStream.hasNext()) {
                String inputData = inputStream.next();
            }
            while (inputStream.hasNext()) {
                String inputData = inputStream.next();
                String[] stringsArray = inputData.split(",");
                date.add(stringsArray[0]);
                txVolumeUSD.add(stringsArray[1]);
                txCount.add(stringsArray[2]);
                marketCupUSD.add(stringsArray[3]);
                priceUSD.add(stringsArray[4]);
                exchangeVolumeUSD.add(stringsArray[5]);
                generatedCoins.add(stringsArray[6]);
                fees.add(stringsArray[7]);
            }
        } catch (FileNotFoundException fnfExc) {
            System.out.println("Invalid file name or wrong path to file!!!");
            System.out.println(fnfExc);
        }

    }

}
