package com.infoshareacademy.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataControler {
    //input data in table with data
    /*
    "DAY(0?[1-9]|
    [12][0-9]|
    3[01])
    MOUNTH/(0?[1-9]|
    1[012])
    YEAR/((19|20)dd)";
    (20dd)    /
    */

    //pattern in regex
    public static final String DATE_REGEXP = "(201[0-9])-(0?[19]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
    Pattern pattern = Pattern.compile(DATE_REGEXP);

    String date = "2017-02-05";
    Matcher matcher = pattern.matcher(date);
    int year = Integer.parseInt((matcher.group(1)));
    String month = matcher.group(2);
    String day = matcher.group(3);

    public boolean dateValidate(){
        if(matcher.find()){
            if((month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) && day.equals("31")){
                return false;
            } else if (year%4 == 0 && month.equals("02") && (day.equals("29") || day.equals("30") || day.equals(31))){

            }








        }






        return true;
    }







    //    public boolean validate(String date){
//        return pattern.matcher(date).matches();
//    }






//    TODO change regex form to LocalDate
//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    public LocalDate getDate(String input) {
//            throw new UnsupportedOperationException("please implement");
//    }
//
//    public boolean isDateValid(String input) {
//        try {
//            FORMATTER.parse(input);
//            return true;
//        } catch (DateTimeParseException e) {
//            return false;
//        }
//    }
}
