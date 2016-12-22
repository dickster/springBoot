package com.brovada.document;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.SimplePath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QQuoteResult is a Querydsl query type for QuoteResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuoteResult extends EntityPathBase<QuoteResult> {

    private static final long serialVersionUID = -1329212646L;

    public static final QQuoteResult quoteResult = new QQuoteResult("quoteResult");

    public final DateTimePath<java.util.Date> created = createDateTime("created", java.util.Date.class);

    public final DateTimePath<java.util.Date> expiry = createDateTime("expiry", java.util.Date.class);

    public final SimplePath<java.util.Optional<java.util.List<String>>> notes = createSimple("notes", java.util.Optional.class);

    public final StringPath quoteMethod = createString("quoteMethod");

    public final StringPath referrer = createString("referrer");

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Double> totalPremium = createNumber("totalPremium", Double.class);

    public QQuoteResult(String variable) {
        super(QuoteResult.class, forVariable(variable));
    }

    public QQuoteResult(Path<? extends QuoteResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuoteResult(PathMetadata metadata) {
        super(QuoteResult.class, metadata);
    }

}

