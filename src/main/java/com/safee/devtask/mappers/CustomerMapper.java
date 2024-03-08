package com.safee.devtask.mappers;

import com.safee.devtask.entities.Customer;
import com.safee.devtask.models.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper extends RootMapper<Customer, CustomerDTO> {

}
