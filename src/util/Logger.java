package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "app_logs.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.write(String.format("[%s] %s%n", timestamp, message));
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}