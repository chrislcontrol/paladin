package com.paladin.paladin.dtos.vehicles;

import com.paladin.paladin.entities.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class VehicleOutputDto {
    private UUID id;
    private String tag;
    private Client client;
}
