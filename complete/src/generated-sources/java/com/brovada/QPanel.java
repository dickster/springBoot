package com.brovada;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPanel is a Querydsl query type for Panel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPanel extends EntityPathBase<Panel> {

    private static final long serialVersionUID = -592290160L;

    public static final QPanel panel = new QPanel("panel");

    public final ListPath<String, StringPath> asyncValidators = this.<String, StringPath>createList("asyncValidators", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<Component, QComponent> children = this.<Component, QComponent>createList("children", Component.class, QComponent.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath label = createString("label");

    public final EnumPath<WidgetType> type = createEnum("type", WidgetType.class);

    public final ListPath<String, StringPath> validators = this.<String, StringPath>createList("validators", String.class, StringPath.class, PathInits.DIRECT2);

    public QPanel(String variable) {
        super(Panel.class, forVariable(variable));
    }

    public QPanel(Path<? extends Panel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPanel(PathMetadata metadata) {
        super(Panel.class, metadata);
    }

}

