package com.example.observerdemo;
/**
 * Observer interface declares the update method.
 * Any class that wants to receive notifications from Subject
 * must implement this interface.
 */
public interface Observer {
    /**
     * Called by Subject when its state changes.
     * @param stockName name of the stock
     * @param newPrice latest price
     */
    void update(String stockName, double newPrice);
}
