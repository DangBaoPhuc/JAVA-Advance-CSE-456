package com.example.observerdemo;
import java.util.*;

/**
 * Simple console UI to demonstrate the Observer pattern in action.
 * Features:
 * 1) Add/Remove investors (observers)
 * 2) Update stock price (subject state)
 * 3) Display current observers
 */

public class ConsoleApp {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo: Stock Notification System ===");
        System.out.print("Enter stock name (default: ACME): ");
        String name = SC.nextLine().trim();
        if (name.isBlank()) name = "ACME";

        double price = readDouble("Enter initial price (default: 100): ", 100.0);
        Stock stock = new Stock(name, price);

        // Seed demo observers
        stock.attach(new Investor("Alice"));
        stock.attach(new Investor("Bob"));

        System.out.println("\nDemo seeded with two investors: Alice, Bob");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ", 0, 6);
            switch (choice) {
                case 1 -> addInvestor(stock);
                case 2 -> removeInvestor(stock);
                case 3 -> updatePrice(stock);
                case 4 -> listInvestors(stock);
                case 5 -> simulateScenario(stock);
                case 6 -> notifyManually(stock);
                case 0 -> running = false;
                default -> System.out.println("Unknown option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1) Add investor (Observer)");
        System.out.println("2) Remove investor (Observer)");
        System.out.println("3) Update stock price (Subject state)");
        System.out.println("4) List observers");
        System.out.println("5) Simulate scenario");
        System.out.println("6) Trigger notify manually (without price change)");
        System.out.println("0) Exit");
    }

    private static void addInvestor(Stock stock) {
        System.out.print("Enter investor name: ");
        String name = SC.nextLine().trim();
        if (name.isBlank()) {
            System.out.println("Name cannot be blank.");
            return;
        }
        Investor inv = new Investor(name);
        stock.attach(inv);
        System.out.println("Added: " + inv);
    }

    private static void removeInvestor(Stock stock) {
        System.out.print("Enter investor name to remove: ");
        String name = SC.nextLine().trim();
        if (name.isBlank()) {
            System.out.println("Name cannot be blank.");
            return;
        }
        Observer toRemove = null;
        for (Observer o : stock.getObservers()) {
            if (o instanceof Investor inv && inv.getName().equalsIgnoreCase(name)) {
                toRemove = o; break;
            }
        }
        if (toRemove != null) {
            stock.detach(toRemove);
            System.out.println("Removed: " + name);
        } else {
            System.out.println("Investor not found: " + name);
        }
    }

    private static void updatePrice(Stock stock) {
        double newPrice = readDouble("Enter new price: ", stock.getPrice());
        stock.setPrice(newPrice);
    }

    private static void listInvestors(Stock stock) {
        System.out.println("Current observers:");
        if (stock.getObservers().isEmpty()) {
            System.out.println("(none)");
            return;
        }
        int i = 1;
        for (Observer o : stock.getObservers()) {
            System.out.println(i++ + ") " + o);
        }
    }

    private static void simulateScenario(Stock stock) {
        System.out.println("Simulating: price rising then falling...");
        double p = stock.getPrice();
        stock.setPrice(p + 5.0);
        sleep(400);
        stock.setPrice(p + 10.0);
        sleep(400);
        stock.setPrice(p + 8.0);
        sleep(400);
        stock.setPrice(p + 12.0);
        sleep(400);
        stock.setPrice(p + 9.0);
        System.out.println("Simulation done.");
    }

    private static void notifyManually(Stock stock) {
        System.out.println("Manual notification (without price change):");
        stock.notifyAllObservers();
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine();
            try {
                int v = Integer.parseInt(line.trim());
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.printf("Please enter an integer in [%d, %d].%n", min, max);
            }
        }
    }

    private static double readDouble(String prompt, double def) {
        while (true) {
            System.out.print(prompt);
            String line = SC.nextLine();
            if (line.isBlank()) return def;
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
