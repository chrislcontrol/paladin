package com.paladin.paladin.use_cases.auth;

import com.paladin.paladin.adapters.JwtService;
import com.paladin.paladin.dtos.auth.AuthenticationOutputDTO;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Token;
import com.paladin.paladin.enums.TokenType;
import com.paladin.paladin.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class AuthenticateUseCase {
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationOutputDTO execute(Client client, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                client.getUsername(),
                password
        );

        this.authenticationManager.authenticate(authToken);
        String jwtToken = this.jwtService.generateToken((UserDetails) client);
        String refreshToken = this.jwtService.generateRefreshToken((UserDetails) client);
        this.revokeAllUserTokens(client);
        this.saveUserToken(client, jwtToken);
        return AuthenticationOutputDTO.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

    private void revokeAllUserTokens(Client client) {
        List<Token> validUserTokens = this.tokenRepository.findAllValidTokenByClient(client.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        this.tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(Client client, String jwtToken) {
        Token token = Token.builder()
                .client(client)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        this.tokenRepository.save(token);
    }
}
