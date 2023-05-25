package com.paladin.paladin.repositories;

import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Token findByClient(Client client);
}
