package com.sinacolada.tiki.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    @NotBlank(message = "valid username required")
    @Size(min = 3, max = 28)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "valid email required")
    @Size(max = 124)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "password required")
    private String password;

    // @Column(name = "active")
    // private boolean active = true;

    // @Column(name = "locked")
    // private boolean locked = false;

    // private Integer failedAttempts = 0;

    // @OneToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    // private Profile profile;

}