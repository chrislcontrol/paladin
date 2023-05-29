package com.paladin.paladin.use_cases.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.paladin.paladin.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class AuthenticateUseCase extends AuthorizationService{

    final AuthenticationManager authenticationManager;

    public String execute(String username, String password) {
        UsernamePasswordAuthenticationToken validation = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(validation);
        var client = (Client) authentication.getPrincipal();

        return JWT.create()
                .withIssuer(this.issuer)
                .withSubject(username)
                .withClaim("id", String.valueOf(client.getId()))
                .withExpiresAt(
                        LocalDateTime.now(ZoneOffset.UTC).plusMinutes(this.jwtExpiration).toInstant(ZoneOffset.UTC)
                ).sign(Algorithm.HMAC256(this.secretKey));
    }
}
