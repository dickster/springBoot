package com.brovada;

import javax.annotation.Nonnull;

public interface Validator<T> {


    @Nonnull ValidationResult validate(T entity);
}
