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
        this.secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
        this.jwtExpiration = 30;
        this.algorithm = Algorithm.HMAC256(this.secretKey);
        this.issuer = "Vehicles";
    }

}
