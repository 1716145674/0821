package com.zqq.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Calendar c= Calendar.getInstance();
        SimpleDateFormat sdg = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date date = new Date(2020-1900,7-1,17);
        String format = sdg.format(date);

        System.out.println(format);


    }
    @Test
    public  void  test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        LocalDateTime.of(2020,7,17,12,12,12);
        System.out.println(localDateTime.getDayOfWeek().getValue());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String format = dateTimeFormatter.format(LocalDate.now());
        System.out.println(format);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String format1 = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(format1);
        TemporalAccessor parse = dateTimeFormatter1.parse("2020-07-17 03-58-04");
        System.out.println(parse);


    }



}
