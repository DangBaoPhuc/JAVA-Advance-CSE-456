package vn.edu.eiu.testlab.paymentdemo.Service;

import vn.edu.eiu.testlab.paymentdemo.Entity.PaymentMethod;


public class PaymentService {
    PaymentMethod paymentMethod;


    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public  void doPayment(double amount){
        paymentMethod.makePayment(amount);
    }
}
