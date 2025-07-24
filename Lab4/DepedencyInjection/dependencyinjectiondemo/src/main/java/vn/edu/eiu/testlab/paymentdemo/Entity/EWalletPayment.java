package vn.edu.eiu.testlab.paymentdemo.Entity;

public class EWalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing E Wallet of $" + amount);
    }
}
