package com.brovada.document.config;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFormConfig is a Querydsl query type for FormConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFormConfig extends EntityPathBase<FormConfig> {

    private static final long serialVersionUID = -2090847181L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFormConfig formConfig = new QFormConfig("formConfig");

    public final QPanelConfig _super = new QPanelConfig(this);

    //inherited
    public final ListPath<String, StringPath> asyncValidators = _super.asyncValidators;

    //inherited
    public final ListPath<ComponentConfig, QComponentConfig> children = _super.children;

    public final StringPath id = createString("id");

    public final StringPath initialFocus = createString("initialFocus");

    //inherited
    public final StringPath label = _super.label;

    public final QLayoutHint layoutHint;

    public final SimplePath<java.util.Locale> locale = createSimple("locale", java.util.Locale.class);

    public final NumberPath<Long> majorVersion = createNumber("majorVersion", Long.class);

    public final NumberPath<Long> minorVersion = createNumber("minorVersion", Long.class);

    //inherited
    public final EnumPath<ComponentType> type = _super.type;

    //inherited
    public final ListPath<String, StringPath> validators = _super.validators;

    public final NumberPath<java.math.BigDecimal> version = createNumber("version", java.math.BigDecimal.class);

    public QFormConfig(String variable) {
        this(FormConfig.class, forVariable(variable), INITS);
    }

    public QFormConfig(Path<? extends FormConfig> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFormConfig(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFormConfig(PathMetadata metadata, PathInits inits) {
        this(FormConfig.class, metadata, inits);
    }

    public QFormConfig(Class<? extends FormConfig> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.layoutHint = inits.isInitialized("layoutHint") ? new QLayoutHint(forProperty("layoutHint")) : null;
    }

}

