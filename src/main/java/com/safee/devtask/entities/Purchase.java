package com.safee.devtask.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase extends BaseEntity {

    // Fields //

    Integer amount;

    @JsonProperty
    @ManyToOne
    private Product product;

    @JsonProperty
    @ManyToOne
    private Customer customer;

}
