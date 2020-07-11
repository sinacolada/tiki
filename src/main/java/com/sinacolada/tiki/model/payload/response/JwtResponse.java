package com.sinacolada.tiki.model.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    private String token;
    private String tokenType = "Bearer";

    public JwtResponse(Long id, String username, String email, List<String> roles, String accessToken) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = accessToken;
    }

}