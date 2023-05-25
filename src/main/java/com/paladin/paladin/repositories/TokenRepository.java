package com.paladin.paladin.repositories;

import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    @Query(value = """
      select t from Token t inner join client u\s
      on t.client.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByClient(UUID id);

    Optional<Token> findByToken(String token);
}
