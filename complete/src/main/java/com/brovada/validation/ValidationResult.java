package com.brovada.validation;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.HashMap;

@Document
public class ValidationResult extends HashMap<String, Object> {

    private static final String VALID_KEY = "isValid";

    public ValidationResult() {
    }

    public ValidationResult(@Nonnull String key, Object value) {
        put(key, value);
    }

    public ValidationResult valid(boolean valid) {
        put(VALID_KEY, valid);
        return this;
    }

    public ValidationResult valid() {
        put(VALID_KEY, true);
        return this;
    }

    public ValidationResult invalid() {
        put(VALID_KEY, false);
        return this;
    }

    public ValidationResult withResult(@Nonnull String key, String value) {
        put(key,value);
        return this;
    }

    public ValidationResult withResult(@Nonnull String key, Object value) {
        put(key, value);
        return this;
    }

    public ValidationResult withResult(@Nonnull Number code) {
        put(code+"", code);
        return this;
    }

    public ValidationResult withResult(@Nonnull Number code, String value) {
        put(code + "", value);
        return this;
    }

}
