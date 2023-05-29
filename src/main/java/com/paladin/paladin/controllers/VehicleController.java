package com.paladin.paladin.controllers;

import com.paladin.paladin.annotations.LoggedUser;
import com.paladin.paladin.entities.Client;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 2900)
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @PostMapping("/create")
    public Client post(@LoggedUser Client client) {

        return client;
    }

}
