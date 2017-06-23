package com.owozniak.helpers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by oscar on 22.06.17.
 */
public class DateParser {

    /**
     * @param date ISO8601 String
     * @return Converted ISO8601 String to a LocalDateTime
     */
    public static LocalDateTime parseStringToDate(String date) {
        return ZonedDateTime.parse(date)
                .toLocalDateTime();
    }

//    public static LocalDateTime parseStringToDate(String date) {
//        ZonedDateTime zonedDate = ZonedDateTime.parse(date);
//
//        return zonedDate.toLocalDateTime();
//    }

    /**
     * @return actual UTC LocalDateTime in ISO8601 String format
     */
    public static String parseNowDateToString() {
        return LocalDateTime.now()
                .atZone(ZoneOffset.UTC)
                .toString();
    }
//    public static String parseNowDateToString() {
//        LocalDateTime now = LocalDateTime.now();
//        ZonedDateTime nowAtZone = now.atZone(ZoneOffset.UTC);
//
//        return nowAtZone.toString();
//    }
}
