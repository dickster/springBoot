package com.brovada;

public class TextField implements Input<String>, HasValidation {

    public TextField() {

    }

    @Override
    public WidgetType getType() {
        return WidgetType.TEXT_FIELD;
    }


}
