# Observer Pattern Demo (Java, Console)

A simple console-based Java application demonstrating the **Observer Design Pattern** 
via a Stock price notification system.

## Structure
- `Subject` / `Observer` interfaces
- `Stock` (ConcreteSubject): maintains state (price) and notifies observers
- `Investor` (ConcreteObserver): receives and prints updates
- `ConsoleApp` (UI): simple menu to attach/detach observers and update stock price

## How to Compile & Run (no build tool)
```bash
cd src/main/java
javac com/example/observerdemo/*.java
java com.example.observerdemo.ConsoleApp
```

## Sample Demo Flow
1. Keep default stock name and initial price.
2. Choose `5) Simulate scenario` to see automatic notifications.
3. Add or remove investors; update price and observe notifications.

## Observer Pattern (short)
- **Intent**: Define a one-to-many dependency between objects so that when one object changes state, 
  all its dependents are notified and updated automatically.
- **Pros**: Loose coupling, easy to extend with new observers.
- **Cons**: Notification overhead with many observers, no guaranteed order.

## Notes
- Java 17+ recommended (but should work on Java 8+).
- For a GUI version, you can wrap Stock events into Swing/JavaFX listeners.
