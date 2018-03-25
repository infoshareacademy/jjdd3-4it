package com.infoshareacademy.cdi;

import com.infoshareacademy.model.CurrencyStatistic;
import com.infoshareacademy.model.InputData;

import javax.ejb.Stateless;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Stateless
public class StatisticsStringConvertBean {

    public String statsName(List<CurrencyStatistic> currencyStatistics) {
        String statsName = "";
        for (int i = 0; i < currencyStatistics.size(); i++) {
            statsName = statsName + "`" + currencyStatistics.get(i).getName() + "`";
            if (i != currencyStatistics.size() - 1) {
                statsName = statsName + ", ";
            }
        }
        return statsName;
    }

    public String statsValue(List<CurrencyStatistic> currencyStatistics) {
        String statsValue = "";
        for (int i = 0; i < currencyStatistics.size(); i++) {
            statsValue = statsValue + currencyStatistics.get(i).getValue();
            if (i != currencyStatistics.size() - 1) {
                statsValue = statsValue + ", ";
            }
        }
        return statsValue;
    }
}
