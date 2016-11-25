package com.brovada.document;


import com.brovada.WidgetType;

import java.util.Optional;

public interface Component {

    WidgetType getType();
    default Optional<String> getCss() { return Optional.empty(); };
}
