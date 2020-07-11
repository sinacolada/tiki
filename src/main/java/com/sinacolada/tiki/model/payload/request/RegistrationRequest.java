package com.sinacolada.tiki.model.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RegistrationRequest {

    @NotBlank
    @Size(min = 3, max = 28)
    private String username;

    @NotBlank
    @Size(max = 124)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 60)
    private String password;

    private Set<String> role;

}