package com.brovada;

import com.google.common.collect.Maps;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class ValidationResult {

    private Map<Long, String> results = Maps.newHashMap();

    public ValidationResult() {
    }

    public ValidationResult(long code, String msg) {
        addResult(code, msg);
    }

    public ValidationResult addResult(long code, String msg) {
        results.put(code, msg);
        return this;
    }

    public ValidationResult addResult(long code) {
        results.put(code, code+"");
        return this;
    }
}
