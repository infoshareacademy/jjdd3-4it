package com.infoshareacademy.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateService {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    static LocalDate dateInRange(String input) throws DateTimeParseException {
        return LocalDate.parse(input);
    }

    static LocalDate dateCorrectFormat(LocalDate date) throws DateTimeParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String formattedDate = date.format(dtf);
        return LocalDate.parse(formattedDate);
    }

    public static LocalDate getDateFromUser() {
        LocalDate result = null;
        boolean flag = false;
        do {
            try {
                result = dateCorrectFormat(dateInRange(InputReaderTool.read()));
                flag = true;
            } catch (DateTimeParseException e) {
                System.out.print("  please write correct format " + DATE_FORMAT + ": ");
            }
        } while (flag == false);
        return result;
    }

}