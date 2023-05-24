package com.paladin.paladin.controllers;

import com.paladin.paladin.dtos.clients.ClientOutputDTO;
import com.paladin.paladin.dtos.clients.CreateClientDTO;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.exceptions.APIResponseError;
import com.paladin.paladin.use_cases.clients.CreateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 2900)
@RequestMapping("clients")
public class ClientController {
    final CreateClientUseCase createClientUseCase;

    public ClientController(CreateClientUseCase service) {
        this.createClientUseCase = service;
    }

    @PostMapping
    public ResponseEntity<ClientOutputDTO> post(@RequestBody @Valid CreateClientDTO createClientDTO)
            throws APIResponseError {
        Client client = this.createClientUseCase.execute(createClientDTO);
        ClientOutputDTO output = new ClientOutputDTO();
        BeanUtils.copyProperties(client, output);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(output);
    }
}
