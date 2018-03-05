package com.infoshareacademy.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateService {
    public static Logger LOG = LoggerFactory.getLogger(DateService.class);
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
                System.out.println("  please write correct format " + DATE_FORMAT + " with 2017 year: ");
                LOG.error("User choose wrong date format {}", result);
            }
        } while (true);
        return result;
    }

}