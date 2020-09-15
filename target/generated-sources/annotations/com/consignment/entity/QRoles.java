package com.consignment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoles is a Querydsl query type for Roles
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoles extends EntityPathBase<Roles> {

    private static final long serialVersionUID = -452008240L;

    public static final QRoles roles = new QRoles("roles");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QRoles(String variable) {
        super(Roles.class, forVariable(variable));
    }

    public QRoles(Path<? extends Roles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoles(PathMetadata metadata) {
        super(Roles.class, metadata);
    }

}

