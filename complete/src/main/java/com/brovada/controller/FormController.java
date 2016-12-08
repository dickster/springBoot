package com.brovada.controller;

import com.brovada.document.config.FormConfig;
import com.brovada.repository.FormRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import javax.inject.Inject;

@RestController
@RequestMapping(value = "/form")
public class FormController {

    private @Inject FormRepository repository;

    @RequestMapping(value = "/{id}")
    public FormConfig get(@PathVariable String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "latest/{id}")
    public @Nullable FormConfig getLatest(@PathVariable String id) {
        return repository.findLatestById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody FormConfig input) {
        System.out.print(input + " --> ");
        FormConfig x = this.repository.save(input);
        System.out.println("saved " + x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


