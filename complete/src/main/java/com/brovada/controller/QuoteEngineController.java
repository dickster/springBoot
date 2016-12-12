package com.brovada.controller;

import com.brovada.document.Quote;
import com.brovada.document.QuoteResult;
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
    ResponseEntity<QuoteResult> add(@RequestBody Quote quote) {
        System.out.print("calculating quote for " + quote);
        double total = Math.random() * 3000 + 150;
        return new ResponseEntity<QuoteResult>(QuoteResult.success(total), HttpStatus.OK);
    }

    // add a method that will calculate quote given QuoteId as parameter.  a headless service. doesn't need a client to POST.
    //   can CURL quotes.

}


