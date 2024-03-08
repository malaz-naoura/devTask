package com.safee.devtask.mappers;

import com.safee.devtask.entities.Purchase;
import com.safee.devtask.models.PurchaseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PurchaseMapper extends RootMapper<Purchase, PurchaseDTO> {

}
