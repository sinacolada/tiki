package com.sinacolada.tiki.model.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    private OffsetDateTime created;

    @Column(name = "updated", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    private OffsetDateTime updated;

    // createdBy

    // updatedBy

}