package com.infoshareacademy.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateService {
    private static final PropertyService propertyService = new PropertyService();
    private static final String DATE_FORMAT = propertyService.getDateFormat();

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
        do {
            try {
                result = dateCorrectFormat(dateInRange(InputReaderService.read()));
                if (result != null && result.getYear() == 2017) {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.print("  please write correct format " + DATE_FORMAT + ": ");
            }
        } while (true);
        return result;
    }

}