package vn.edu.eiu.testlab.paymentdemo.Entity;

public class CardPayment implements PaymentMethod{
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing card payment of $" + amount);
    }
}
