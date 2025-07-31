package vn.edu.eiu.lab5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.repository.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public void createCustomer(Customer Customer){
        // Them cac thao tac kiem tra du lieu cho Customer
        customerRepo.save(Customer);
    }
    public Customer getCustomer(int id){
        return   CustomerRepo.findById(id);
    }
    public List<Customer> getAllCustomers(){
        return CustomerRepo.findAll();

    }
    public void deleteCustomer(Customer Customer){
        CustomerRepo.remove(Customer);
    }
    public void updateCustomer(Customer Customer){
        CustomerRepo.update(Customer);
    }
}
