package com.infoshareacademy;

import com.infoshareacademy.view.DataControler;


public class App {
    public static void main(String[] args) {
        DataControler dataControler = new DataControler();
        System.out.println(dataControler.getDate("2017-02-30"));


    }
}

