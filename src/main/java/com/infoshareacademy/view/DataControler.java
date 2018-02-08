package com.infoshareacademy.view;

import java.util.ArrayList;
import java.util.List;
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