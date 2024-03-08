package com.safee.devtask.mappers;

import com.safee.devtask.entities.Product;
import com.safee.devtask.models.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper extends RootMapper<Product, ProductDTO> {

}
