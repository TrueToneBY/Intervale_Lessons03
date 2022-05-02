package com.intervale.cources.library.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHour {
    public static String format(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDateTime.format(formatter);
    }
}
