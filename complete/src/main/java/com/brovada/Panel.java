package com.brovada;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Panel implements Component, HasChildren, HasValidation {

    private String label;
    private List<String> validators;
    private List<String> asyncValidators;
    private List<Component> children;

    @Id
    public String id;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public WidgetType getType() {
        return WidgetType.PANEL;
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    public Panel withChildren(List<Component> children) {
        this.children = children;
        return this;
    }

    public Panel withValidators(List<String> validators) {
        this.validators = validators;
        return this;
    }

    public Panel withAsyncValidators(List<String> asyncValidators) {
        this.asyncValidators = asyncValidators;
        return this;
    }

    public Panel withLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getValidators() {
        return validators;
    }

    public List<String> getAsyncValidators() {
        return asyncValidators;
    }
}
