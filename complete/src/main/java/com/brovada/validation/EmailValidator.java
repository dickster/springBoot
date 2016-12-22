package com.brovada.validation;

import com.brovada.document.User;
import com.brovada.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Map;

@Component
@ValidationParams( {@ValidationParam(value = "email", type=String.class)} )
public class EmailValidator implements Validator {

    @Inject
    private UserRepository userRepository;

    @Nonnull
    @Override
    public ValidationResult validate(Map<String,String> params) {
        // ensure given email address is NOT already in use.
        String email = params.get("email");
        User userWithEmail = userRepository.findByEmail(email);
        if (userWithEmail==null) {
            return ValidationResult.valid().withResult("it works");
        }
        else {
            return ValidationResult.invalid().withResult(-735, "email address " + email + " already in use");
        }
    }
}
