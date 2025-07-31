package vn.edu.eiu.lab5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.entity.Invoice;
import vn.edu.eiu.lab5.entity.Product;
import vn.edu.eiu.lab5.service.InvoiceService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        InvoiceService invoiceService = context.getBean(InvoiceService.class);

        // ✅ CREATE
        System.out.println("----- CREATE -----");
        Customer customer1 = new Customer();
        customer1.setName("Nguyen Van A");
        customer1.setEmail("a@gmail.com");

        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Mouse", 5);

        Invoice invoice1 = new Invoice();
        invoice1.setCustomer(customer1);
        invoice1.addProduct(p1);
        invoice1.addProduct(p2);

        invoiceService.createInvoice(invoice1);

        System.out.println("Invoice 1 created: ID = " + invoice1.getInvoice_id());

        // Tạo thêm hóa đơn thứ 2
        Customer customer2 = new Customer();
        customer2.setName("Nguyen Van B");
        customer2.setEmail("b@gmail.com");

        Product p3 = new Product("Keyboard", 50);
        Product p4 = new Product("Headphones", 80);

        Invoice invoice2 = new Invoice();
        invoice2.setCustomer(customer2);
        invoice2.addProduct(p3);
        invoice2.addProduct(p4);

        invoiceService.createInvoice(invoice2);
        System.out.println("Invoice 2 created: ID = " + invoice2.getInvoice_id());

        // ✅ READ ONE
        System.out.println("\n----- READ ONE -----");
        Invoice fetchedInvoice = invoiceService.getInvoice(invoice1.getInvoice_id());
        System.out.println("Invoice ID: " + fetchedInvoice.getInvoice_id());
        System.out.println("Customer: " + fetchedInvoice.getCustomer().getName());
        fetchedInvoice.getProducts().forEach(p ->
                System.out.println("- " + p.getName() + ": $" + p.getPrice())
        );

        // ✅ READ ALL
        System.out.println("\n----- READ ALL -----");
        List<Invoice> allInvoices = invoiceService.getAllInvoice();
        allInvoices.forEach(inv -> {
            System.out.println("Invoice #" + inv.getInvoice_id() + " - Customer: " + inv.getCustomer().getName());
            inv.getProducts().forEach(p ->
                    System.out.println("  * " + p.getName() + ": $" + p.getPrice()));
        });

        // ✅ UPDATE
        System.out.println("\n----- UPDATE -----");
        fetchedInvoice.removeProduct(p2); // remove mouse
        Product pNew = new Product("USB Drive", 15);
        fetchedInvoice.addProduct(pNew);
        invoiceService.updateInvoice(fetchedInvoice);

        System.out.println("Updated invoice ID " + fetchedInvoice.getInvoice_id());
        Invoice updatedInvoice = invoiceService.getInvoice(fetchedInvoice.getInvoice_id());
        updatedInvoice.getProducts().forEach(p ->
                System.out.println("- " + p.getName() + ": $" + p.getPrice()));

        // ✅ DELETE
//        System.out.println("\n----- DELETE -----");
//        invoiceService.deleteInvoice(invoice2);
//        System.out.println("Deleted invoice ID: " + invoice2.getInvoice_id());
//
//        // Verify delete
//        List<Invoice> invoicesAfterDelete = invoiceService.getAllInvoice();
//        System.out.println("Remaining invoices:");
//        invoicesAfterDelete.forEach(inv ->
//                System.out.println("- Invoice ID " + inv.getInvoice_id()));
    }
}

