package com.safee.devtask.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RefundDTO extends RootDTO {

    // Fields //
    Integer amount;

    @JsonProperty
    private PurchaseDTO purchase;

}
