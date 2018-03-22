package com.infoshareacademy.cdi;

import com.infoshareacademy.model.InputData;

import javax.enterprise.context.RequestScoped;
import java.util.List;

import static java.util.stream.Collectors.joining;

@RequestScoped
public class AxisStringConverterBean {

    public String axisX(List<InputData> inputData){
        String axisX = "";
        for (int i = 0; i < inputData.size();i++ ) {
            axisX = axisX + "'" + inputData.get(i).getDate() + "'";
            if (i != inputData.size()-1) {
                axisX = axisX + ",";
            }
        }
        return axisX;
    }

    public String axisY(List<InputData> inputData){
        String axisY = "";
        for (int i = 0; i < inputData.size();i++ ) {
            axisY = axisY + "'" + inputData.get(i).getPrice() + "'";
            if (i != inputData.size()-1) {
                axisY = axisY + ",";
            }
        }
        return axisY;
    }
}
