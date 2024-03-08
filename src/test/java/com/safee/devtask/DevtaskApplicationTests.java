package com.safee.devtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevtaskApplicationTests {
//
//
//    @Autowired
//    WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//    private final ObjectMapper objectMapper;
//    private final CustomerController customerController;
//    private final ProductController productController;
//    private final PurchaseController purchaseController;
//    private final RefundController refundController;
//
//    public DevtaskApplicationTests(MockMvc mockMvc, ObjectMapper objectMapper, CustomerController customerController,
//                                   ProductController productController, PurchaseController purchaseController,
//                                   RefundController refundController orderController) {
//        this.objectMapper = objectMapper;
//        this.customerController = customerController;
//        this.productController = productController;
//        this.purchaseController = purchaseController;
//        this.refundController = refundController;
//
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
//                                      .build();
//    }
//
    @Test
    void contextLoads() {
    }
//
//    @Test
//    void testEntities() throws Exception {
//        //Customers
//        Customer c1 = Customer.builder()
//                              .name("customer_1")
//                              .phone("111")
//                              .build();
//        Customer c2 = Customer.builder()
//                              .name("customer_2")
//                              .phone("222")
//                              .build();
//
////
////        customerController.saveNewObject(c1);
////        customerController.save(c2);
//
//        mockMvc.perform(post(CustomerController.PATH).contentType(MediaType.APPLICATION_JSON)
//                                                     .content(objectMapper.writeValueAsString(c1)))
//               .andExpect(status().isCreated());
////
////        MvcResult mvcResult = mockMvc.perform(
////                                             patch(JuiceController.JUICE_PATH_ID, juice.getId()).accept(MediaType.APPLICATION_JSON)
////                                                                                                .contentType(MediaType.APPLICATION_JSON)
////                                                                                                .content(objectMapper.writeValueAsString(juice)))
////                                     .andExpect(status().isBadRequest())
////                                     .andReturn();
////
////        System.out.println(mvcResult.getResponse()
////                                    .getContentAsString());
//
//        // Products
//        Product prod1 = Product.builder()
//                               .name("product_1")
//                               .price(BigDecimal.valueOf(1.1))
//                               .build();
//
//        Product prod2 = Product.builder()
//                               .name("product_2")
//                               .price(BigDecimal.valueOf(2.2))
//                               .build();
//
////        productController.save(prod1);
////        productController.save(prod2);
////
////        // Purchase
////        Purchase purchase1 = Purchase.builder()
////                                     .name("purchase1")
////                                     .product(prod1)
////                                     .amount(3)
////                                     .build();
////
////        // Orders
////        Order order1 = Order.builder()
////                            .orderDate(LocalDateTime.now())
////                            .build();
////        order1.addOrderItem(purchase1);
////
////        orderController.save(order1);
////
////        // Refunds
////        Refund refund1 = Refund.builder()
////                               .purchase(purchase1)
////                               .amount(1)
////                               .build();
////
////        // Orders
////        Order order2 = Order.builder()
////                            .orderDate(LocalDateTime.now())
////                            .build();
////        order2.addOrderItem(refund1);
////
////        orderController.save(order2);
//    }
}
