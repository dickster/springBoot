package com.brovada.controller;

import com.brovada.document.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quote/calculate")
public class QuoteEngineController {

    // it's possible that you might want caching on this.
    // it should be treated as a GET then most likely.  caching POSTs is not recommended in general.
    // a very dangerous undertaking indeed if you do decide to cache!
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Double> add(@RequestBody Quote quote) {

        // in real life, you'd probably want to return something more than just the number.
        // maybe comments, notes, status codes, expiry date, meta data etc...
        System.out.print("calculating quote for " + quote);
        return new ResponseEntity<Double>(Math.random()*3000+150, HttpStatus.OK);
    }

}


