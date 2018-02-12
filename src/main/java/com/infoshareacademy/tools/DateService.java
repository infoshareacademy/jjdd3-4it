package com.infoshareacademy.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateService {

    public static final String DATE_FORRMAT = "yyyy-MM-dd";

    LocalDate dateCorrectFormat(String input) throws DateTimeParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORRMAT);
        return LocalDate.parse(input, dtf);
    }

    public LocalDate getDateFromUser() {
        LocalDate result = null;
        boolean flag = false;
        do {
            try {
                result = dateCorrectFormat(InputReaderTool.read());
                System.out.println(result);
                flag = true;
            } catch (DateTimeParseException e) {
                System.out.println("plese write correct format " + DATE_FORRMAT);
            }
        } while (flag == false);
        return result;
    }


}





