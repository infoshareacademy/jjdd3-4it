package com.infoshareacademy;

import com.infoshareacademy.view.DataControler;


public class App {
    public static void main(String[] args) {

    DataControler dateControler = new DataControler();
        System.out.println("00"+dateControler.isDateExists("2016-03-00"));
        System.out.println("28"+dateControler.isDateExists("2016-03-28"));
        System.out.println("29"+dateControler.isDateExists("2016-04-29"));
        System.out.println("30"+dateControler.isDateExists("2016-04-30"));
        System.out.println("31"+dateControler.isDateExists("2016-04-31"));
        System.out.println("32"+dateControler.isDateExists("2016-04-32"));


    }
}

