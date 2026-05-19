package org.sebsy.grasps.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitaire spécialisée dans les conversions de dates.
 */
public class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDateTime toDate(String dateStr) {

        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}
