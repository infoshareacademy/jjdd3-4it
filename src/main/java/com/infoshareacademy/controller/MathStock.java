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
    private int cycle = 10;//to zarkres naszej średniej. użytkownik musi przypisywać tą wart np z zakresu 10-45
    private double movingAveragePrice;
    List<Double> listForAverragePrice = new ArrayList<Double>();


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

    public List<Double> movingAverragePriceForRange(List<InputData> resources) {
        int r = 0;
        for (int i = cycle; i <= resources.size(); i++) {
            movingAveragePrice = 0;
            for (int j = 0 + r; j < cycle + r; j++) {
                movingAveragePrice += resources.get(j).getPrice();
            }
            movingAveragePrice /= cycle;
            listForAverragePrice.add(r, movingAveragePrice);
            r++;
        }
        return listForAverragePrice;
    }


}