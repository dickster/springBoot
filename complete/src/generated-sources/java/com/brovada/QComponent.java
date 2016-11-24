package com.brovada;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComponent is a Querydsl query type for Component
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QComponent extends BeanPath<Component> {

    private static final long serialVersionUID = 1834240905L;

    public static final QComponent component = new QComponent("component");

    public final SimplePath<java.util.Optional<String>> css = createSimple("css", java.util.Optional.class);

    public final StringPath id = createString("id");

    public final EnumPath<WidgetType> type = createEnum("type", WidgetType.class);

    public QComponent(String variable) {
        super(Component.class, forVariable(variable));
    }

    public QComponent(Path<? extends Component> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComponent(PathMetadata metadata) {
        super(Component.class, metadata);
    }

}

