package com.paladin.paladin.controllers;


import com.paladin.paladin.dtos.auth.AuthenticationDataDTO;
import com.paladin.paladin.dtos.auth.AuthenticationOutputDTO;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.exceptions.APIResponseError;
import com.paladin.paladin.repositories.ClientRepository;
import com.paladin.paladin.use_cases.auth.AuthenticateUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", maxAge = 2900)
@RequestMapping("auth")
public class AuthController {
    final private ClientRepository clientRepository;
    final private AuthenticateUseCase authenticateUseCase;


    public AuthController(ClientRepository clientRepository, AuthenticateUseCase authenticateUseCase) {
        this.clientRepository = clientRepository;
        this.authenticateUseCase = authenticateUseCase;
    }


    @PostMapping
    public ResponseEntity<AuthenticationOutputDTO> post(@RequestBody @Valid AuthenticationDataDTO authenticationData)
        throws APIResponseError {
        String username = authenticationData.getUserName()
        Client client = this.clientRepository.findByUsername()
    }


}
