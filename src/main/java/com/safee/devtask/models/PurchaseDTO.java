package com.safee.devtask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO extends RootDTO {

    // Fields //

    Integer amount;

    @JsonProperty
    private ProductDTO product;

    @JsonProperty
    private CustomerDTO customer;

}
