package com.safee.devtask.bootstrap;

import com.safee.devtask.entities.Customer;
import com.safee.devtask.entities.Product;
import com.safee.devtask.entities.Purchase;
import com.safee.devtask.entities.Refund;
import com.safee.devtask.repositories.CustomerRepo;
import com.safee.devtask.repositories.ProductRepo;
import com.safee.devtask.repositories.PurchaseRepo;
import com.safee.devtask.repositories.RefundRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final PurchaseRepo purchaseRepo;
    private final RefundRepo refundRepo;

    @Override
    public void run(String... args) {

        //Customers
        Customer c1 = Customer.builder()
                              .name("customer_1")
                              .phone("111")
                              .build();
        Customer c2 = Customer.builder()
                              .name("customer_2")
                              .phone("222")
                              .build();

        customerRepo.save(c1);
        customerRepo.save(c2);

        // Products
        Product prod1 = Product.builder()
                               .name("product_1")
                               .price(BigDecimal.valueOf(1.1))
                               .build();
        Product prod2 = Product.builder()
                               .name("product_2")
                               .price(BigDecimal.valueOf(2.2))
                               .build();

        productRepo.save(prod1);
        productRepo.save(prod2);

        // Purchase
        Purchase purchase1 = Purchase.builder()
                                     .product(prod1)
                                     .customer(c1)
                                     .amount(3)
                                     .build();
        Purchase purchase2 = Purchase.builder()
                                     .product(prod2)
                                     .customer(c2)
                                     .amount(6)
                                     .build();

        purchaseRepo.save(purchase1);
        purchaseRepo.save(purchase2);

        // Refunds
        Refund refund1 = Refund.builder()
                               .purchase(purchase1)
                               .amount(1)
                               .build();
        Refund refund2 = Refund.builder()
                               .purchase(purchase2)
                               .amount(2)
                               .build();

        refundRepo.save(refund1);
        refundRepo.save(refund2);

    }
}
