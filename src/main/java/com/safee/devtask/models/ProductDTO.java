package com.safee.devtask.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends RootDTO {

    // Fields //

    @NotNull
    @NotBlank
    @Size(max = 40)
    protected String name;

    protected BigDecimal price;

}
