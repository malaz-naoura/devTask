package com.safee.devtask.controllers;

import com.safee.devtask.models.PurchaseDTO;
import com.safee.devtask.services.domain.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PurchaseController implements RootContorller<PurchaseDTO> {

    private final PurchaseService purchaseService;

    public static final String name = "/purchase";
    public static final String PATH = CONSTANTS.ENDPOINT_URL_PRFIX + name;
    public static final String PATH_ID = PATH + "/{id}";

    @Override
    @PostMapping(PATH)
    public ResponseEntity<PurchaseDTO> saveNewObject(PurchaseDTO object) {
        PurchaseDTO purchaseDTO = purchaseService.saveNewObject(object);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(purchaseDTO);
    }

}
