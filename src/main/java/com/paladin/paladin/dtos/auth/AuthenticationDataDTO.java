package com.paladin.paladin.dtos.auth;

import com.paladin.paladin.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDataDTO {
    @NotBlank
    @Size(max = 10)
    private Client client;

    @NotBlank
    @Size(max = 20)
    private String password;
}
