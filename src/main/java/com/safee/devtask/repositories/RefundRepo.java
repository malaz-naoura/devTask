package com.safee.devtask.repositories;

import com.safee.devtask.entities.Refund;

import java.time.LocalDateTime;
import java.util.List;

public interface RefundRepo extends RootRepo<Refund, Long> {
    List<Refund> findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(LocalDateTime start, LocalDateTime end);

}