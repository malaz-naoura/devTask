package com.safee.devtask.controllers;

import com.safee.devtask.models.ProductDTO;
import com.safee.devtask.services.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ProductController implements RootContorller<ProductDTO> {

    private final ProductService productService;

    public static final String name = "/product";
    public static final String PATH = CONSTANTS.ENDPOINT_URL_PRFIX + name;
    public static final String PATH_ID = PATH + "/{id}";


    @Override
    @PostMapping(PATH)
    public ResponseEntity<ProductDTO> saveNewObject(ProductDTO object) {
        ProductDTO productDTO = productService.saveNewObject(object);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(productDTO);
    }

    @Override
    @PutMapping(PATH_ID)
    public ResponseEntity<ProductDTO> updateObject(Long id, ProductDTO object) {
        ProductDTO productDTO = productService.updateObjectById(id, object)
                                              .orElse(null);

        HttpStatus currStatus = productDTO != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(currStatus)
                             .body(productDTO);
    }

    @Override
    @DeleteMapping(PATH_ID)
    public ResponseEntity<Void> deleteById(Long id) {
        Boolean deleted = productService.deleteObjectById(id);

        HttpStatus currStatus = deleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(currStatus)
                             .build();
    }
}
