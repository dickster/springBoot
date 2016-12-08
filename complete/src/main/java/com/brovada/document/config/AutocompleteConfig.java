package com.brovada.document.config;

import com.brovada.ComponentType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AutocompleteConfig<T> extends InputConfig<T> implements HasValidation {

    private String formControlName;
    private ChoiceProvider<T> choiceProvider = new ChoiceProvider();

    public AutocompleteConfig(String formControlName) {
        super(ComponentType.AUTOCOMPLETE, formControlName);
    }

    public boolean isRemote() {
        return choiceProvider.isRemote();
    }


}
