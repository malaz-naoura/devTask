package com.safee.devtask.repositories;

import com.safee.devtask.entities.Purchase;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepo extends RootRepo<Purchase, Long> {
    List<Purchase> findAllByCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(LocalDateTime start, LocalDateTime end);
}