# Payment Processing Demo App

## Project Structure

This demo app demonstrates a payment system that supports:
- Credit/Debit Card
- eWallet
- Bank Transfer

It uses:
- **3-Layer Architecture**
- **Dependency Injection (DI)**
- **Open-Closed Principle (OCP)**

## III. Discuss Question

### 1. Is the layered design reasonable?

✅ **Yes, the 3-layer design is reasonable and recommended for small to medium applications.**

- **Presentation Layer (Main.java):**
  - Acts as an entry point.
  - Handles user-level logic (e.g., selecting payment type).
- **Service Layer (PaymentService.java):**
  - Handles business logic using dependency injection.
  - Respects the Single Responsibility Principle (SRP).
- **Data Layer (PaymentMethod implementations):**
  - Provides concrete strategies for different payment types.
  - Easy to extend by adding new classes implementing `PaymentMethod`.
