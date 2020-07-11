package com.sinacolada.tiki.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.sinacolada.tiki.model.pojo.ERole;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, updatable = false, length = 60)
    @NotNull
    private ERole name;

    // @Column(name = "description", nullable = false)
    // @NotNull
    // private String description;

    // @OneToMany
    // private Set<Permission> permissions;

}