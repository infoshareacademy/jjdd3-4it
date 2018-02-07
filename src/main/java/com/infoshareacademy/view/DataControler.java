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

    //Matcher matcher = pattern.matcher("1215");
    public boolean validate(String date){
        return pattern.matcher(date).matches();
    }






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
