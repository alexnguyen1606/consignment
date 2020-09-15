package com.consignment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBorrowedLockers is a Querydsl query type for BorrowedLockers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBorrowedLockers extends EntityPathBase<BorrowedLockers> {

    private static final long serialVersionUID = 4747450L;

    public static final QBorrowedLockers borrowedLockers = new QBorrowedLockers("borrowedLockers");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath insuranceCode = createString("insuranceCode");

    public final NumberPath<Long> lockersId = createNumber("lockersId", Long.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath note = createString("note");

    public QBorrowedLockers(String variable) {
        super(BorrowedLockers.class, forVariable(variable));
    }

    public QBorrowedLockers(Path<? extends BorrowedLockers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBorrowedLockers(PathMetadata metadata) {
        super(BorrowedLockers.class, metadata);
    }

}

