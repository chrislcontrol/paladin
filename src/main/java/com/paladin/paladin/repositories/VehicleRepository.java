package com.paladin.paladin.repositories;

import com.paladin.paladin.entities.Client;
import com.paladin.paladin.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findByTagAndClient(String tag, Client client);
    boolean existsByTagAndClient(String tag, Client client);
}
