package com.paladin.paladin.repositories;

import com.paladin.paladin.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByUsername(String username);
    Optional<Client> findByUsername(String username);
}
