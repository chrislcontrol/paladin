package com.paladin.paladin.use_cases.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class ValidateTokenUseCase extends AuthorizationService {
    public String execute(String token) {
        return JWT.require(Algorithm.HMAC256(this.secretKey))
                .withIssuer(this.issuer)
                .build().verify(token).getSubject();
    }
}
