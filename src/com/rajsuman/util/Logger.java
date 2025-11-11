package com.rajsuman.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public static synchronized void logToFile(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tea_orders.txt", true))) {
            writer.write(log);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }public static synchronized void logError(String errorMessage) {
        try (FileWriter writer = new FileWriter("error.log", true)) {
            writer.write(errorMessage + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write to error.log: " + e.getMessage());
        }
    }public static synchronized void logOrder(String orderMessage) {
        try (FileWriter writer = new FileWriter("orders.log", true)) {
            writer.write(orderMessage + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write to orders.log: " + e.getMessage());
        }
    }
}