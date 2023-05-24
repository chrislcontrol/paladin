package com.paladin.paladin.dtos.clients;

import java.util.UUID;

public class ClientOutputDTO {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private UUID id;
    private String username;
}
