package com.consignment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLockers is a Querydsl query type for Lockers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLockers extends EntityPathBase<Lockers> {

    private static final long serialVersionUID = -1626419282L;

    public static final QLockers lockers = new QLockers("lockers");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isActive = createBoolean("isActive");

    public final NumberPath<Integer> limit = createNumber("limit", Integer.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QLockers(String variable) {
        super(Lockers.class, forVariable(variable));
    }

    public QLockers(Path<? extends Lockers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLockers(PathMetadata metadata) {
        super(Lockers.class, metadata);
    }

}

