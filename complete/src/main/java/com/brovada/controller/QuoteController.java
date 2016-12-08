package com.brovada.controller;

import com.brovada.document.Quote;
import com.brovada.repository.QuoteRepository;
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
@RequestMapping(value = "/quote")
public class QuoteController {

    private @Inject QuoteRepository repository;

    @RequestMapping(value = "/{id}")
    public Quote employee(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Quote> employeeByName(@RequestParam(value="name", defaultValue="alice") String name) {
        return repository.findContains(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Quote input) {
        System.out.print(input + " --> ");
        Quote x = this.repository.save(input);
        //if i want this cacheable, add headers?  really, i would only want static stuff cacheable...images, pdfs, ?  static data like company names...
        // really, this would be addressed at tomcat level.   eg. anything under url /data/blah/ mark as cacheable via web.xml.
            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl("private, max-age=3600");
        //
        System.out.println(x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}


