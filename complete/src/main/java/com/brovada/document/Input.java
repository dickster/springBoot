package com.brovada.document;

import com.brovada.WidgetType;

import java.util.Optional;

public abstract class Input<T> implements Component {

    private final WidgetType type;

    protected Input(WidgetType type) {
        this.type = type;
    }

    Optional<InputType> getInputType() { return Optional.of(InputType.TEXT); }
    boolean isRequired() { return true; };
    Optional<T> defaultValue() { return Optional.empty(); }
    Optional<T> order() { return Optional.empty(); }

}
