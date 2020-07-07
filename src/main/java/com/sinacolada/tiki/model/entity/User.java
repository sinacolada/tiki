package com.sinacolada.tiki.model.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    // @SequenceGenerator(name = "user_userId_seq", sequenceName =
    // "user_userId_seq", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "user_userId_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false)
    private int id;

    @Column(unique = true, nullable = false)
    @NotNull
    private String username;

    @Column(unique = true, nullable = false)
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    private String password;

    private Integer failedAttempts;

    @Column(name = "date_joined", nullable = false, updatable = false)
    @CreationTimestamp
    private Date dateJoined;

    @Column(name = "date_updated", nullable = false, updatable = false)
    @UpdateTimestamp
    private Date dateUpdated;

    private boolean active;

    private boolean disabled = false;

    @OneToMany
    @NotNull
    private Set<Role> roles;

    @Embedded
    private UserInformation userInformation;

}