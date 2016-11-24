package com.brovada;

import java.util.Optional;

public interface Component {

    String getId();
    WidgetType getType();
    default Optional<String> getCss() { return Optional.empty(); };
}
