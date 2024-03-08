package com.safee.devtask.mappers;


public interface RootMapper<OBJ,DTO> {
    OBJ dtoToObj(DTO objectDto);

    DTO objToDto(OBJ object);
}
