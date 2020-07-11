package com.sinacolada.tiki.security.user;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinacolada.tiki.model.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

public class UserDetailsAdapter implements UserDetails {

    private String username;

    @JsonIgnore
    private String password;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsAdapter(String username, String password, Long id, String email,
            Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserDetailsAdapter build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserDetailsAdapter(user.getUsername(), user.getPassword(), user.getId(), user.getEmail(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsAdapter user = (UserDetailsAdapter) o;
        return Objects.equals(this.id, user.id);
    }

    /**
    *
    */
    private static final long serialVersionUID = 1L;

}