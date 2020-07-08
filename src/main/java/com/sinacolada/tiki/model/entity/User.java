package com.sinacolada.tiki.model.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotNull
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "date_joined", nullable = false, updatable = false)
    @CreationTimestamp
    private Date dateJoined;

    @Column(name = "date_updated", nullable = false, updatable = false)
    @UpdateTimestamp
    private Date dateUpdated;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "disabled")
    private boolean disabled = false;

    private Integer failedAttempts;

    @OneToMany
    @NotNull
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

}