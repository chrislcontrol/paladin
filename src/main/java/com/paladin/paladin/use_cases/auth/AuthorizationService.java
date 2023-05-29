package com.paladin.paladin.use_cases.auth;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    final String secretKey;
    final int jwtExpiration;
    final Algorithm algorithm;
    final String issuer;

    public AuthorizationService() {
        this.secretKey = "xpto";
        this.jwtExpiration = 30;
        this.algorithm = Algorithm.HMAC256(this.secretKey);
        this.issuer = "vehicles";
    }

}
