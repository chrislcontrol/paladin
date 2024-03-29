package com.paladin.paladin.adapters;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encryptor {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encrypt(String value) {
        return this.encoder.encode(value);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return this.encoder.matches(rawPassword, encodedPassword);
    }

    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
