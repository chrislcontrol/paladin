package com.paladin.paladin.controllers;

import com.paladin.paladin.annotations.LoggedClient;
import com.paladin.paladin.dtos.vehicles.CreateVehicleDto;
import com.paladin.paladin.dtos.vehicles.VehicleOutputDto;
import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Vehicle;
import com.paladin.paladin.use_cases.vehicles.CreateVehicleUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 2900)
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    final CreateVehicleUseCase createVehicleUseCase;

    @PostMapping("/create")
    public ResponseEntity<VehicleOutputDto> post(@LoggedClient Client client,
                                                 @RequestBody @Valid CreateVehicleDto requestBody) {
        Vehicle vehicle = this.createVehicleUseCase.execute(requestBody.getTag(), client);
        VehicleOutputDto output = new VehicleOutputDto();

        BeanUtils.copyProperties(vehicle, output);

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

}
