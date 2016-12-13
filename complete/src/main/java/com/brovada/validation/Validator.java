package com.brovada.validation;

import javax.annotation.Nonnull;
import java.util.Map;

public interface Validator {

    @Nonnull ValidationResult validate(Map<String,String> params);
}
