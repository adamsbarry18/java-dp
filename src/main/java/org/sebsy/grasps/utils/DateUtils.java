package org.sebsy.grasps.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDateTime toDate(String dateStr) {

        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}
