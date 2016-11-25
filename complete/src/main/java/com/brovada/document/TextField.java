package com.brovada.document;

import com.brovada.WidgetType;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TextField extends Input<String> implements HasValidation {

    private String formControlName;

    public TextField(String formControlName) {
        super(WidgetType.TEXT_FIELD);
        this.formControlName = formControlName;
    }

    @Override
    public WidgetType getType() {
        return WidgetType.TEXT_FIELD;
    }

    public String getFormControlName() {
        return formControlName;
    }

    @Override
    public String toString() {
        return "TextField{" +
                "formControlName='" + formControlName + '\'' +
                '}';
    }
}
