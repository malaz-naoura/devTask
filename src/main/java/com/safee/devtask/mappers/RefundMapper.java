package com.safee.devtask.mappers;

import com.safee.devtask.entities.Refund;
import com.safee.devtask.models.RefundDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RefundMapper extends RootMapper<Refund, RefundDTO> {

}
