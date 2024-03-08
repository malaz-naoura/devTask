package com.safee.devtask.models;

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
public class CustomerDTO extends RootDTO {

    // Fields //

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String name;

    private String phone;

}
