package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Optional;

@Document
public class FormConfig extends PanelConfig {

    private @Nonnull BigDecimal version;

    private @Nonnull Locale locale = Locale.getDefault();
    private String initialFocus;
    private LayoutHint layoutHint;

    public FormConfig() {
    }

    public FormConfig withLocale(@Nonnull Locale locale) {
        this.locale = locale;
        return this;
    }

    public FormConfig withInitialFocus(@Nonnull String inputId) {
        this.initialFocus = inputId;
        return this;
    }

    public FormConfig withLayoutHint(@Nonnull LayoutHint layoutHint) {
        this.layoutHint = layoutHint;
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

    @Nonnull
    public Locale getLocale() {
        return locale;
    }


    public Optional<String> getInitialFocus() {
        return Optional.ofNullable(initialFocus);
    }


    public Optional<LayoutHint> getLayoutHint() {
        return Optional.of(layoutHint);
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
