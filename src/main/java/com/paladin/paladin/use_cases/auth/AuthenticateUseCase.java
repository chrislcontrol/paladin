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
}
