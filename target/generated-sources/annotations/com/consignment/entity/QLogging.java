package com.consignment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogging is a Querydsl query type for Logging
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLogging extends EntityPathBase<Logging> {

    private static final long serialVersionUID = -1622840654L;

    public static final QLogging logging = new QLogging("logging");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> lockerId = createNumber("lockerId", Long.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath type = createString("type");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QLogging(String variable) {
        super(Logging.class, forVariable(variable));
    }

    public QLogging(Path<? extends Logging> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogging(PathMetadata metadata) {
        super(Logging.class, metadata);
    }

}

