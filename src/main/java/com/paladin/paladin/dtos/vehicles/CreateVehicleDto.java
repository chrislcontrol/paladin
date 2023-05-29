package com.paladin.paladin.dtos.vehicles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateVehicleDto {
    @NotBlank
    @Size(max = 8)
    private String tag;
}
