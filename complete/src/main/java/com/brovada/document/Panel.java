package com.brovada.document;

import com.brovada.WidgetType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Panel implements Component, HasChildren, HasValidation {

    protected String label;
    protected List<String> validators;
    protected List<String> asyncValidators;
    protected List<? extends Component> children;

    @Id
    public String id;

    @Override
    public WidgetType getType() {
        return WidgetType.PANEL;
    }

    @Override
    public List<? extends Component> getChildren() {
        return children;
    }

    public <T extends Panel> T withChildren(List<? extends Component> children) {
        this.children = children;
        return (T) this;
    }

    public <T extends Panel> T withValidators(List<String> validators) {
        this.validators = validators;
        return (T) this;
    }

    public <T extends Panel> T withAsyncValidators(List<String> asyncValidators) {
        this.asyncValidators = asyncValidators;
        return (T) this;
    }

    public <T extends Panel> T withLabel(String label) {
        this.label = label;
        return (T) this;
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
