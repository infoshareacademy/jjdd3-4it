package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class MathStock {

    private double averagePrice;
    private double medianPrice;

    List<Double> listHelp = new ArrayList<Double>();


    public double averragePriceForRange(List<InputData> resources) {


        for (int i = 0; i < resources.size(); i++) {
            averagePrice += resources.get(i).getPrice();
        }
        averagePrice /= (resources.size());

        return averagePrice;
    }


    public double medianPriceForRange(List<InputData> resources) {
        for (int i = 0; i < resources.size(); i++) {
            listHelp.add(resources.get(i).getPrice());

        }
        Collections.sort(listHelp);
        int medianRange = resources.size();
        if (medianRange % 2 != 0) {
            medianRange = (medianRange - 1) / 2;
            medianPrice = listHelp.get(medianRange);
            return medianPrice;

        } else {
            medianRange = medianRange / 2;
            medianPrice = (listHelp.get(medianRange) + listHelp.get(medianRange - 1)) / 2;
            return medianPrice;
        }

    }


}