package com.sinacolada.tiki.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.errorprone.annotations.Immutable;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "desc", nullable = false)
    private String description;

    @Column(name = "created", nullable = false)
    @CreationTimestamp
    private Date dateCreated;

}