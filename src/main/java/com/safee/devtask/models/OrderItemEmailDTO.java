package com.safee.devtask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEmailDTO {

    public Long id;

    public  Integer amount;

    public String productName;

    public String customerName;

}