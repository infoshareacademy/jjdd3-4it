package com.infoshareacademy.view;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataControlerTest  {

//    private DataControler subject;
//
//    @Before
//    public void setup() {
//        subject = new DataControler();
//    }
//
//    @Test
//    public void shouldParseDate() {
//        // given
//        LocalDate expected = LocalDate.of(2017, 12, 24);
//        DataControler subject = new DataControler();
//        // when
//        LocalDate actual = subject.getDate("2017-12-24");
//        // then
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldValidateDate() {
//        String input = "2017-12-24";
//        boolean actual = subject.isDateValid(input);
//        assertTrue(actual);
//
//    }
//
//    @Test
//    public void shouldNotValidateDate() {
//        String input = "2017-02-30";
//        boolean actual = subject.isDateValid(input);
//        assertFalse(actual);
//
//    }

    @Test
    public void getDate(){
        String s = "2017-12-40";
        LocalDate now = LocalDate.parse(null);
        System.out.println(now);
        System.out.println(now.toString());
    }
}