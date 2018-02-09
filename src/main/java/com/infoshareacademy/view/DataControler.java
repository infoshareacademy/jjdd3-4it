package com.infoshareacademy.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataControler {
    public static final String DATE_REGEXP = "(201[0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
    public static final String MENU_REGEXP = "[0-9]";
    private Pattern datePattern = Pattern.compile(DATE_REGEXP);
    private Pattern menuPattern = Pattern.compile(MENU_REGEXP);

    public boolean isDateExists(String date) {
        Matcher matcher = datePattern.matcher(date);
        if (matcher.matches()) {
            return isDateInRange(matcher);
        }
        return false;
    }

    private boolean isDateInRange(Matcher matcher) {
        int year = Integer.parseInt((matcher.group(1)));
        String month = matcher.group(2);
        String day = matcher.group(3);

        if ((month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) && day.equals("31")) {
            return false;
        } else if (month.equals("02") && (day.equals("30") || day.equals("31") || (year % 4 == 0 && day.equals("29")))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMenuNumberInRange(String menuNumber){
        Matcher matcher = menuPattern.matcher(menuNumber);
        return matcher.matches();
    }


//    private void run() {
//
//        String value = scanner();
//
//        if (isFormatCorrect(value)) {
//            if (isDateValid(value)) {
//                return localDate;
//            } else {
//                run();
//        } else {
//          run();
//        }
//    }
//
//    private boolean isFormatCorrect(String input) {
//        return false;
//    }

//    private LocalDate parseDate(String input) throws DateTimeParseException, NullPointerException {
//        return LocalDate.parse(input);
//    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    public void run() {
//        LocalDate date = null;
//        while(date == null) {
//            input = scanner.get();
//            date = getDate(input);
//        }
//    }

    public void dateValid(String inputDate) throws DateTimeParseException {
            DATE_FORMATTER.parse(inputDate);
    }

    public LocalDate getDateInRange(String inputDate) throws DateTimeParseException{
        return LocalDate.parse(inputDate);
    }

    //pobieranie
    public LocalDate getDate(String input) throws DateTimeParseException {
            dateValid(input);
            return  getDateInRange(input);

//
//        if(is()){
//            return LocalDate.parse(input);
//        } else{
//            System.out.println("please write correct format");
//            return getDate(input);
//        }

    }

}


