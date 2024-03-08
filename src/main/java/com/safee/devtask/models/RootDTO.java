package com.safee.devtask.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class RootDTO {

    protected Long id;

    protected LocalDateTime createdDate;

    protected LocalDateTime updateDate;

}
