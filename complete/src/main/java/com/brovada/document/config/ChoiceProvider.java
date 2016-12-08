package com.brovada.document.config;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class ChoiceProvider<T> {

    private String url;
    // TODO : can use a simple list if you just want values (not key-->values)
    private Map<T, Object> choices;

    /*package protected constructor and methods*/
    ChoiceProvider() {
    }

    ChoiceProvider withInlineChoices(@Nonnull Map<T,Object> choices) {
        Preconditions.checkState(this.choices == null && url == null, "You can't set provider more than once");
        this.choices = choices;
        return this;
    }

    ChoiceProvider withInlineChoices(@Nonnull List<T> choices) {
        Preconditions.checkState(this.choices == null && url == null, "You can't set provider more than once");
        this.choices = Maps.toMap(choices, new Function<T, Object>() {
            @Override @Nullable public Object apply(@Nullable T input) {
                return input!=null ? input.toString() : null;
            }
        });
        return this;
    }

    ChoiceProvider withRemoteChoices(@Nonnull String url) {
        Preconditions.checkState(choices==null && this.url==null, "You can't set provider more than once");
        this.url = url;
        return this;
    }

    public boolean isRemote() {
        return url != null;
    }
}

