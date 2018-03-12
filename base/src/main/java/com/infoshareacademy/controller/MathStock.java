package com.infoshareacademy.controller;

import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MathStock {

    private double averagePrice;
    private double medianPrice;
    private static final Logger LOG = LoggerFactory.getLogger(MathStock.class);

    List<Double> listHelp = new ArrayList<Double>();
    private int cycle = 4;
    private double movingAveragePrice;
    List<Double> listForAveragePrice = new ArrayList<Double>();


    public double averagePriceForRange(List<InputData> resources) {


        for (int i = 0; i < resources.size(); i++) {
            averagePrice += resources.get(i).getPrice();
        }
        averagePrice /= (resources.size());
        LOG.info("Average Price is compute", averagePrice);
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
            LOG.info("Median Price is compute", medianPrice);
            return medianPrice;

        } else {
            medianRange = medianRange / 2;
            medianPrice = (listHelp.get(medianRange) + listHelp.get(medianRange - 1)) / 2;
            LOG.info("Median Price is compute", medianPrice);
            return medianPrice;
        }

    }

    public List<Double> movingAveragePriceForRange(List<InputData> resources) {
        int r = 0;
        for (int i = cycle; i <= resources.size(); i++) {
            movingAveragePrice = 0;
            for (int j = 0 + r; j < cycle + r; j++) {
                movingAveragePrice += resources.get(j).getPrice();
            }
            movingAveragePrice /= cycle;
            listForAveragePrice.add(r, movingAveragePrice);
            r++;
        }
        LOG.info("Moving average Price is compute", movingAveragePrice);
        return listForAveragePrice;
    }


}