package com.brovada;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFormConfig is a Querydsl query type for FormConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFormConfig extends EntityPathBase<FormConfig> {

    private static final long serialVersionUID = 935427098L;

    public static final QFormConfig formConfig = new QFormConfig("formConfig");

    public final QPanel _super = new QPanel(this);

    //inherited
    public final ListPath<String, StringPath> asyncValidators = _super.asyncValidators;

    //inherited
    public final ListPath<Component, QComponent> children = _super.children;

    public final StringPath id = createString("id");

    public final StringPath initialFocus = createString("initialFocus");

    //inherited
    public final StringPath label = _super.label;

    // custom
    public final QLayoutHint layoutHint = new QLayoutHint(forProperty("layoutHint"));

    public final SimplePath<java.util.Locale> locale = createSimple("locale", java.util.Locale.class);

    public final NumberPath<Integer> majorVersion = createNumber("majorVersion", Integer.class);

    public final StringPath minorVersion = createString("minorVersion");

    //inherited
    public final EnumPath<WidgetType> type = _super.type;

    //inherited
    public final ListPath<String, StringPath> validators = _super.validators;

    public QFormConfig(String variable) {
        super(FormConfig.class, forVariable(variable));
    }

    public QFormConfig(Path<? extends FormConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFormConfig(PathMetadata metadata) {
        super(FormConfig.class, metadata);
    }

}

