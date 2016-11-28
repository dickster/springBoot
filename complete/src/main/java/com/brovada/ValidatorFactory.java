package com.brovada;

import javax.annotation.Nonnull;

public class ValidatorFactory<T> {

    public Validator<T> create(String name) {
        switch (name) {

            // add other cases here...

            default:
                return new Validator<T>() {
                    @Override
                    public @Nonnull ValidationResult validate(T entity) {
                        return new ValidationResult(-1, "hello");
                    }
                };
        }
    }
}
