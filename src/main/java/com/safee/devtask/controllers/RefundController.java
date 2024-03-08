package com.safee.devtask.controllers;

import com.safee.devtask.models.RefundDTO;
import com.safee.devtask.services.domain.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class RefundController implements RootContorller<RefundDTO> {

    private final RefundService refundService;

    public static final String name = "/refund";
    public static final String PATH = CONSTANTS.ENDPOINT_URL_PRFIX + name;
    public static final String PATH_ID = PATH + "/{id}";

    @Override
    @PostMapping(PATH)
    public ResponseEntity<RefundDTO> saveNewObject(RefundDTO object) {
        RefundDTO refundDTO = refundService.saveNewObject(object);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(refundDTO);
    }

}
