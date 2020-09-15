package com.consignment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserRoleMapping is a Querydsl query type for UserRoleMapping
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserRoleMapping extends EntityPathBase<UserRoleMapping> {

    private static final long serialVersionUID = 698972928L;

    public static final QUserRoleMapping userRoleMapping = new QUserRoleMapping("userRoleMapping");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserRoleMapping(String variable) {
        super(UserRoleMapping.class, forVariable(variable));
    }

    public QUserRoleMapping(Path<? extends UserRoleMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRoleMapping(PathMetadata metadata) {
        super(UserRoleMapping.class, metadata);
    }

}

