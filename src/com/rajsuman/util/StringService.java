package com.rajsuman.util;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatOrderLog(String studentName, String flavor, int quantity) {
        String timestamp = formatter.format(LocalDateTime.now());
        return "[" + timestamp + "] Order from " + studentName + ": " + quantity + " x " + flavor;
    }
}