package vn.edu.eiu.testlab.paymentdemo.Entity;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Bank Transfer payment of $" + amount);
    }
}
