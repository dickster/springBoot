package com.brovada.controller;

import com.brovada.validation.ValidationResult;
import com.brovada.validation.Validator;
import com.brovada.validation.ValidatorFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Map;

@RestController
@RequestMapping(value = "/validate")
public class ValidatorController {

    // typically used in conjunction with ng2 async validators.

    private @Inject ValidatorFactory validatorFactory;

    @RequestMapping(value = "/{validatorName}", method = RequestMethod.GET)
    ValidationResult validate( @PathVariable String validatorName, @RequestParam Map<String,String> params) {
        Validator validator = validatorFactory.create(validatorName, params);
        ValidationResult result = validator.validate(params);
        return result;
    }

}


