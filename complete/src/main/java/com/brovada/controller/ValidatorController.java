package com.brovada.controller;

import com.brovada.validation.ValidationResult;
import com.brovada.validation.Validator;
import com.brovada.validation.ValidatorFactory;
import com.brovada.document.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/validate")
public class ValidatorController {

    // typically used in conjunction with ng2 async validators.

    private @Inject ValidatorFactory<Quote> validatorFactory;

    @RequestMapping(value = "/{validatorName}", method = RequestMethod.POST)
    ResponseEntity<?> validate(@RequestBody Quote quote, @PathVariable String validatorName) {
        Validator<Quote> validator = validatorFactory.create(validatorName);
        ValidationResult result = validator.validate(quote);
        return new ResponseEntity<ValidationResult>(result, HttpStatus.CREATED);
    }

}


