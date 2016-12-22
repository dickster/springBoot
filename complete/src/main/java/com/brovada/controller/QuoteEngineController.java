package com.brovada.controller;

import com.brovada.document.Quote;
import com.brovada.document.QuoteResult;
import com.brovada.repository.QuoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping(value = "/quote/calculate")
public class QuoteEngineController {

    private @Inject QuoteRepository quoteRepository;

    // it's possible that you might want caching on this.
    // it should be treated as a GET then most likely.  caching POSTs is not recommended in general.
    // a very dangerous undertaking indeed if you do decide to cache!
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<QuoteResult> add(@RequestBody Quote quote) {
        System.out.print("calculating quote for " + quote);

        double total = calculate(quote);
        QuoteResult result = QuoteResult.success(total);
        quote.result = Optional.of(result);
        quoteRepository.save(quote);
        return new ResponseEntity<QuoteResult>(result, HttpStatus.OK);
    }

    private double calculate(Quote quote) {
        return Math.random() * 3000 + 150;
    }

    // add a method that will calculate quote given QuoteId as parameter.  a headless service. doesn't need a client to POST.
    //   can CURL quotes.

}


