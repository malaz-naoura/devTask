package com.safee.devtask.services.domain;

import com.safee.devtask.models.PurchaseDTO;

import java.util.List;

public interface PurchaseService extends RootService<PurchaseDTO,Long> {

    List<PurchaseDTO> getAllYesterday();
}
