package com.brovada;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/broker")
public class BrokerController {

    private @Inject BrokerRepository repository;

    @RequestMapping(value = "/{id}")
    public Broker employee(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Broker> employeeByName(@RequestParam(value="name", defaultValue="") String name) {
        return repository.find(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Broker input) {
        Broker x = this.repository.save(input);
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl("public, max-age=290304000");
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


