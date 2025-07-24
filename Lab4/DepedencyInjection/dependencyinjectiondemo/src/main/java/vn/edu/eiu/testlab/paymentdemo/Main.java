package vn.edu.eiu.testlab.paymentdemo;

import vn.edu.eiu.testlab.paymentdemo.Entity.BankTransferPayment;
import vn.edu.eiu.testlab.paymentdemo.Entity.CardPayment;
import vn.edu.eiu.testlab.paymentdemo.Entity.EWalletPayment;
import vn.edu.eiu.testlab.paymentdemo.Entity.PaymentMethod;
import vn.edu.eiu.testlab.paymentdemo.Service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentMethod paymentMethod = new CardPayment();
        PaymentService paymentService = new PaymentService(paymentMethod);


        PaymentMethod paymentMethod1 = new BankTransferPayment();
        PaymentService paymentService1 = new PaymentService(paymentMethod1);


        PaymentMethod paymentMethod2 = new EWalletPayment();
        PaymentService paymentService2 = new PaymentService(paymentMethod2);


        paymentService.doPayment(200000);
        paymentService1.doPayment(200000);
        paymentService2.doPayment(200000);
    }
}
