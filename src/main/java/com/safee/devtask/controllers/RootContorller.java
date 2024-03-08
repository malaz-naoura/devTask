package com.safee.devtask.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface RootContorller<T> {

    default Page<T> getAllObject(  @RequestParam(required = false) Integer pageNumber,
                           @RequestParam(required = false) Integer pageSize){
        return null;
    };

    default ResponseEntity<T> getObjectById(@PathVariable("id") Long id) {
        return null;
    }

    default ResponseEntity<T> saveNewObject(@Validated @RequestBody T object) {
        return null;
    }

    default ResponseEntity<T> updateObject(@Validated @PathVariable("id") Long id, @RequestBody T object) {
        return null;
    }

    default ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        return null;
    }
}