package com.paladin.paladin.dtos.clients;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateClientDTO {
    @NotBlank
    @Size(max = 10)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
