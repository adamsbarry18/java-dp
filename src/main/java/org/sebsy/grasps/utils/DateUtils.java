package org.sebsy.grasps.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilitaire spécialisée dans les conversions de dates.
 */
public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Convertit une String en LocalDateTime selon le format dd/MM/yyyy HH:mm:ss.
     *
     * @param dateStr date au format String
     * @return LocalDateTime
     */
    public static LocalDateTime toDate(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }
}
