package com.safee.devtask.controllers;

import com.safee.devtask.models.CustomerDTO;
import com.safee.devtask.services.domain.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class CustomerController implements RootContorller<CustomerDTO> {

    private final CustomerService customerService;

    public static final String name = "/customer";
    public static final String PATH = CONSTANTS.ENDPOINT_URL_PRFIX + name;
    public static final String PATH_ID = PATH + "/{id}";


    @Override
    @PostMapping(PATH)
    public ResponseEntity<CustomerDTO> saveNewObject(CustomerDTO object) {
        CustomerDTO customerDTO = customerService.saveNewObject(object);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(customerDTO);
    }

    @Override
    @PutMapping(PATH_ID)
    public ResponseEntity<CustomerDTO> updateObject(Long id, CustomerDTO object) {
        CustomerDTO customerDTO = customerService.updateObjectById(id,object)    .orElse(null);

        HttpStatus currStatus = customerDTO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(currStatus)
                             .body(customerDTO);
    }

    @Override
    @DeleteMapping(PATH_ID)
    public ResponseEntity<Void> deleteById(Long id) {
        Boolean deleted = customerService.deleteObjectById(id);

        HttpStatus currStatus=deleted? HttpStatus.NO_CONTENT :HttpStatus.NOT_FOUND;
        return ResponseEntity.status(currStatus).build();
    }
}
