package com.uco.graduationproject.burstcar.application.vehiclefeature.comand.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoSaveVehicleFeature {
    private String licensePlate;
    private String model;
    private String brand;
}
