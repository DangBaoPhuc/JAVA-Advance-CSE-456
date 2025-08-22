package com.example.observerdemo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Concrete Observer: Investor
 * Receives updates from the Subject and reacts (here: prints to console).
 */
public class Investor implements Observer {
    private final String name;

    public Investor(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Investor name cannot be null/blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String stockName, double newPrice) {
        // Simple console-based reaction with timestamp
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.printf("[%s] Investor %s notified: %s is now $%.2f%n", ts, name, stockName, newPrice);
    }

    @Override
    public String toString() {
        return "Investor{name='%s'}".formatted(name);
    }
}
