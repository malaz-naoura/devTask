package com.safee.devtask.services.domain;

import com.safee.devtask.models.RefundDTO;

import java.util.List;

public interface RefundService extends RootService<RefundDTO,Long> {
    List<RefundDTO> getAllYesterday();

}
