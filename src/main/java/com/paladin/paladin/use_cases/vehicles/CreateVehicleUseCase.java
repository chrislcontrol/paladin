package com.paladin.paladin.use_cases.vehicles;

import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Vehicle;
import com.paladin.paladin.exceptions.VehicleAlreadyExists;
import com.paladin.paladin.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVehicleUseCase {
    final VehicleRepository vehicleRepository;

    public Vehicle execute(String tag, Client client) {
        boolean alreadyExists = this.vehicleRepository.existsByTagAndClient(tag, client);
        if (alreadyExists) {
            throw new VehicleAlreadyExists();
        }

        return this.createVehicle(tag, client);

    }

    private Vehicle createVehicle(String tag, Client client) {
        Vehicle vehicle = new Vehicle();
        vehicle.setTag(tag);
        vehicle.setClient(client);

        this.vehicleRepository.save(vehicle);

        return vehicle;
    }
}
