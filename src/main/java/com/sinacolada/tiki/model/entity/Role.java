package com.sinacolada.tiki.model.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false, updatable = false, length = 60)
    @NotNull
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "created", updatable = false, nullable = false)
    @NotNull
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "updated", nullable = false)
    @NotNull
    @UpdateTimestamp
    private Date dateUpdated;

    @OneToMany
    private Set<Permission> permissions;

}