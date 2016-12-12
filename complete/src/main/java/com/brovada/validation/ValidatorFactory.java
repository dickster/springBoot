package com.brovada.validation;

import javax.annotation.Nonnull;

// server side validation factory.
// note that these are the things that are (typically) called by angular 2 asyncValidators.
//  angular 2 non-asyncValidators are all on the client side and have nothing to do with these.
public interface ValidatorFactory<T> {

    public @Nonnull Validator<T> create(String name);

}
