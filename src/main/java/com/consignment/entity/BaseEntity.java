package com.consignment.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;


    @LastModifiedDate
    private LocalDateTime modifiedDate;


    @CreatedBy
    @Column(columnDefinition = "nvarchar(255)")
    private String createdBy;


    @LastModifiedBy
    @Column(columnDefinition = "nvarchar(255)")
    private String modifiedBy;
}
