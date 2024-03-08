package com.safee.devtask.services.domain.jpa;

import com.safee.devtask.models.CustomerDTO;
import com.safee.devtask.services.domain.CustomerService;
import com.safee.devtask.services.RootServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class CustomerServiceJPAImplTest implements RootServiceTest {

    @Autowired
    CustomerService customerService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @Override
    public void getObjectById() {

        Long id = 1L;

        CustomerDTO customerDTO = customerService.getObjectById(id)
                                                 .orElse(null);
        Assertions.assertThat(customerDTO)
                  .isNotNull();
        Assertions.assertThat(customerDTO.getId())
                  .isEqualTo(id);
    }

    @Test
    @Override
    public void getAllObjects() {
        Page<CustomerDTO> customerDTOs = customerService.getAllObjects(0, 10);
        Assertions.assertThat(customerDTOs)
                  .hasSizeGreaterThan(0);
        System.out.println(customerDTOs);
    }

    @Test
    @Override
    public void saveNewObject() {

        CustomerDTO newCustomer = CustomerDTO.builder()
                                             .name("test")
                                             .phone("123")
                                             .build();

        CustomerDTO customerDTO = customerService.saveNewObject(newCustomer);
        Assertions.assertThat(customerDTO)
                  .isNotNull();
        Assertions.assertThat(customerDTO.getId())
                  .isNotNull();
    }

    @Test
    @Override
    public void updateObjectById() {

        Long id = 1L;
        CustomerDTO oldCustomerDTO = customerService.getObjectById(id)
                                                    .orElse(null);

        String newName = "newName";
        oldCustomerDTO.setName(newName);

        CustomerDTO updatedCustomerDTO = customerService.updateObjectById(id, oldCustomerDTO)
                                                        .orElse(null);

        Assertions.assertThat(updatedCustomerDTO)
                  .isNotNull();
        Assertions.assertThat(updatedCustomerDTO.getId())
                  .isEqualTo(id);
        Assertions.assertThat(updatedCustomerDTO.getName())
                  .isEqualTo(newName);
    }


    @Test
    @Override
    public void deleteObjectById() {

        CustomerDTO newCustomer = CustomerDTO.builder()
                                             .name("test")
                                             .phone("123")
                                             .build();

        CustomerDTO savedCustomerDTO = customerService.saveNewObject(newCustomer);
        Long id=savedCustomerDTO.getId();

        customerService.deleteObjectById(id);

        CustomerDTO customerDTO = customerService.getObjectById(id)
                .orElse(null);

        Assertions.assertThat(customerDTO)
                  .isNull();

    }
}