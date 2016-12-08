package com.brovada.document.config;

import com.brovada.ComponentType;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.Map;

@Document
public class DropDownConfig<T> extends InputConfig<T> implements HasValidation {

    private @Nonnull ChoiceProvider<T> choiceProvider = new ChoiceProvider();

    public DropDownConfig(String formControlName) {
        super(ComponentType.DROP_DOWN, formControlName);
    }

    public DropDownConfig withInlineChoices(Map<T,Object> choices) {
        this.choiceProvider = new ChoiceProvider<T>().withInlineChoices(choices);
        return this;
    }

    public DropDownConfig withRemoteChoices(String url) {
        this.choiceProvider = new ChoiceProvider<T>().withRemoteChoices(url);
        return this;
    }

    //TODO : add options like search, scrolling parms etc...

}
