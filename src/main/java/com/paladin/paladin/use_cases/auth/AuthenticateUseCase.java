package com.paladin.paladin.use_cases.auth;

import com.paladin.paladin.adapters.Encryptor;
import com.paladin.paladin.dtos.auth.AuthenticationDataDTO;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Token;
import com.paladin.paladin.exceptions.InvalidToken;
import com.paladin.paladin.repositories.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateUseCase {
    final private TokenRepository tokenRepository;
    final private Encryptor encryptor;

    public AuthenticateUseCase(TokenRepository tokenRepository, Encryptor encryptor) {
        this.tokenRepository = tokenRepository;
        this.encryptor = encryptor;
    }


    public String execute(Client client, String rawPassword) throws InvalidToken {
        String encodedPassword = client.getPassword();
        this.validatePassword(rawPassword, encodedPassword);

        return token;
    }

    private Token createToken(Client client) throws InvalidToken {
        Token alreadyToken = this.tokenRepository.findByClient(client);
        if (alreadyToken != null) {
            throw new InvalidToken(null, null, null);
        }

        return token.getToken();
    }

    private void validatePassword(String rawPassword, String encodedPassword) throws InvalidToken {
        boolean isValid = this.encryptor.matches(rawPassword, encodedPassword);
        if (!isValid) {
            throw new InvalidToken(null, null, null);
        }
    }

}
