package com.brovada.validation;

import com.brovada.document.Quote;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;


@Component
public class QuoteValidatorFactory implements ValidatorFactory<Quote> {

    public @Nonnull
    Validator<Quote> create(String name) {
        switch (name) {

            // add other cases here...

            default:
                return new Validator<Quote>() {
                    @Override
                    public @Nonnull ValidationResult validate(Quote quote) {
                        return new ValidationResult().valid().withResult("hello", "world");
                    }
                };
        }
    }


}
