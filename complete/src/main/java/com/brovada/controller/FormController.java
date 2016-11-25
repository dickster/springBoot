package com.brovada.controller;

import com.brovada.document.Form;
import com.brovada.repository.FormRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/form")
public class FormController {

    private @Inject FormRepository repository;

    @RequestMapping(value = "/{id}")
    public Form get(@PathVariable String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "latest/{id}")
    public Form getLatest(@PathVariable String id) {
        return repository.findLatestById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Form input) {
        System.out.print(input + " --> ");
        Form x = this.repository.save(input);
        System.out.println("saved " + x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


