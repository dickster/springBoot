package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Optional;

@Document
public class FormConfig extends PanelConfig {

    private @Nonnull BigDecimal version;

    private Optional<Locale> locale;
    private Optional<String> initialFocus;
    private Optional<LayoutHint> layoutHint;

    public FormConfig() {
    }

    public FormConfig withLocale(@Nonnull Locale locale) {
        this.locale = Optional.of(locale);
        return this;
    }

    public FormConfig withInitialFocus(@Nonnull String inputId) {
        this.initialFocus = Optional.of(inputId);
        return this;
    }

    public FormConfig withLayoutHint(@Nonnull LayoutHint layoutHint) {
        this.layoutHint = Optional.of(layoutHint);
        return this;
    }

    public FormConfig withVersion(@Nonnull Integer major, @Nonnull Integer minor) {
        this.version = new BigDecimal(major+"."+minor);
        return this;
    }

    public FormConfig withVersion(@Nonnull BigDecimal version) {
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
        return locale.orElse(null);
    }

    @Nullable
    public String getInitialFocus() {
        return initialFocus.orElse(null);
    }

    @Nullable
    public LayoutHint getLayoutHint() {
        return layoutHint.orElse(null);
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
