package com.brovada.document;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Locale;

@Document
public class Form extends Panel {

    private @Nonnull BigDecimal version;

    private @Nullable Locale locale;
    private @Nullable String initialFocus;
    private @Nullable
    LayoutHint layoutHint;


    public Form() {
    }

    public Form withLocale(@Nullable Locale locale) {
        this.locale = locale;
        return this;
    }

    public Form withInitialFocus(@Nullable String inputId) {
        this.initialFocus = inputId;
        return this;
    }

    public Form withLayoutHint(@Nullable LayoutHint layoutHint) {
        this.layoutHint = layoutHint;
        return this;
    }

    public Form withVersion(@Nonnull Integer major, @Nonnull Integer minor) {
        this.version = new BigDecimal(major+"."+minor);
        return this;
    }

    public Form withVersion(@Nonnull BigDecimal version) {
        this.version = version;
        return this;
    }

    @Nonnull
    public BigDecimal getVersion() {
        return version;
    }

    public long getMajorVersion() {
        return version.toBigInteger().longValue();
    }

    public long getMinorVersion() {
        double v = version.doubleValue();
        return (long) (v - (long)v);
    }

    @Nullable
    public Locale getLocale() {
        return locale;
    }

    @Nullable
    public String getInitialFocus() {
        return initialFocus;
    }

    @Nullable
    public LayoutHint getLayoutHint() {
        return layoutHint;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id='" + getId() + '\'' +
                ", initialFocus='" + initialFocus + '\'' +
                ", layoutHint=" + layoutHint +
                ", locale=" + locale +
                ", children=" + getChildren() +
                ", majorVersion=" + getMajorVersion() +
                ", minorVersion=" + getMinorVersion() +
                ", version=" + version +
                '}';
    }
}

//    version: xyz
//    locale: UK    <-- can be set dynamically.
//    initialFocus: -- default to smallest #/first
//    validators: ["a", "b"]
//    questions : [
//    { type:  label:  order:  required: id:  dropdownvalues:  defaultValue? validators:["required"] ,asyncValidator:[]  css: },
//    { type:  label:  order:  required: id:  dropdownvalues:
//    dependents :  [{ type: label: order : required: id:  when:[valueA,valueB,valueF] },
//        { type: label: order : required: id:  when:"valueB" }]
//        //any level of dependents...
//    }
//    { type:  label:  order:  required: id:  defaultValue:  autocompleteRestUrl:  otherNg2CompleterAttributes },
//    { type:  label:  order:  required: id:  defaultValue: inputType /* html5 type */},
