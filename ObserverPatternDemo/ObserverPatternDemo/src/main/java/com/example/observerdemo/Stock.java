package com.example.observerdemo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Concrete Subject: Stock
 * Holds an internal state (price) and notifies observers whenever the state changes.
 */
public class Stock implements Subject {
    private final String stockName;
    private final List<Observer> observers = new ArrayList<>();
    private double price;

    public Stock(String stockName, double initialPrice) {
        if (stockName == null || stockName.isBlank()) {
            throw new IllegalArgumentException("stockName cannot be null or blank");
        }
        this.stockName = stockName;
        this.price = initialPrice;
    }

    /**
     * Set a new price. Triggers notification to observers if price actually changes.
     */
    public void setPrice(double newPrice) {
        if (Double.compare(this.price, newPrice) != 0) {
            this.price = newPrice;
            notifyAllObservers();
        }
    }

    public double getPrice() {
        return price;
    }

    public String getStockName() {
        return stockName;
    }

    @Override
    public void attach(Observer observer) {
        if (observer == null) return;
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }

    @Override
    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }
}
