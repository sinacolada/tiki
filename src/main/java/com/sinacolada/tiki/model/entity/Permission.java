package com.sinacolada.tiki.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false, updatable = false, length = 60)
    @NotNull
    private String name;

    // @Column(name = "description", nullable = false, updatable = false)
    // @NotNull
    // private String description;

}