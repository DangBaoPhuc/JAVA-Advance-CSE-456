package vn.edu.eiu.lab5.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.lab5.entity.Product;
import vn.edu.eiu.lab5.repository.ProductRepo;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(Product product){
        // Them cac thao tac kiem tra du lieu cho Product
        ProductRepo.save(product);
    }
    public Product getProduct(int id){
        return   ProductRepo.findById(id);
    }
    public List<Product> getAllProducts(){
        return ProductRepo.findAll();

    }
    public void deleteProduct(Product product){
        ProductRepo.remove(product);
    }
    public void updateProduct(Product product){
        ProductRepo.update(product);
    }
}

