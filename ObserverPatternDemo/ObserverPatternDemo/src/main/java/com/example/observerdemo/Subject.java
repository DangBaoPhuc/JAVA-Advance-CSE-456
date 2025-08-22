package com.example.observerdemo;
import java.util.List;
/**
 * Subject interface declares methods to manage observers.
 * Concrete subjects will implement how they register/deregister observers,
 * and how they notify them.
 */
public interface Subject {
    /**
     * Register a new observer to receive updates.
     * @param observer the observer to add
     */
    void attach(Observer observer);

    /**
     * Unregister an existing observer.
     * @param observer the observer to remove
     */
    void detach(Observer observer);

    /**
     * Notify all registered observers of a state change.
     */
    void notifyAllObservers();

    /**
     * Utility method for UI: read-only list of current observers (optional).
     * @return unmodifiable list of observers
     */
    List<Observer> getObservers();
}
