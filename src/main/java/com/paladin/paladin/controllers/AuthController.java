package com.paladin.paladin.controllers;


import com.paladin.paladin.dtos.auth.AuthenticationDataDTO;
import com.paladin.paladin.dtos.auth.AuthenticationOutputDTO;
import com.paladin.paladin.exceptions.APIResponseError;
import com.paladin.paladin.use_cases.auth.AuthenticateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 2900)
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    final AuthenticateUseCase authenticateUseCase;

    @PostMapping
    public ResponseEntity<AuthenticationOutputDTO> post(@RequestBody @Valid AuthenticationDataDTO authenticationData)
            throws APIResponseError {
        String username = authenticationData.getUsername();
        String password = authenticationData.getPassword();
        String token = this.authenticateUseCase.execute(username, password);

        AuthenticationOutputDTO outputData = new AuthenticationOutputDTO(token);

        return ResponseEntity.status(HttpStatus.OK).body(outputData);

    }


}
