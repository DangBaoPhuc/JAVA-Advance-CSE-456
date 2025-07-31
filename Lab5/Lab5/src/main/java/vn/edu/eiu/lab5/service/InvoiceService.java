package vn.edu.eiu.lab5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.repository.CustomerRepo;
import vn.edu.eiu.lab5.repository.InvoiceRepo;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepo invoiceRepo;

    public void createInvoice(Invoice invoice){
        // Them cac thao tac kiem tra du lieu cho Customer
        invoiceRepo.save(invoice);
    }
    public Invoice getInvoice(int id){
        return   invoiceRepo.findById(id);
    }
    public List<Invoice> getAllInvoice(){
        return invoiceRepo.findAll();

    }
    public void deleteInvoice(Invoice invoice){
        invoiceRepo.remove(invoice);
    }
    public void updateInvoice(Invoice invoice){
        invoiceRepo.update(invoice);
    }
}
