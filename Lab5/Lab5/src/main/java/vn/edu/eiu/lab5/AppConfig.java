package vn.edu.eiu.lab5;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vn.edu.eiu.lab5.repository.CustomerRepo;
import vn.edu.eiu.lab5.repository.InvoiceRepo;
import vn.edu.eiu.lab5.repository.ProductRepo;
import vn.edu.eiu.lab5.service.InvoiceService;

@Configuration
@ComponentScan(basePackages = {"vn.edu.eiu.lab5.repository","vn.edu.eiu.lab5.service"})
public class AppConfig {





}
