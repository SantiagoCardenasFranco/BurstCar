package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;

@Getter
public class VehicleFeatures {

    private final String licensePlate;
    private final String model;
    private final String brand;

    public static VehicleFeatures of(String licensePlate, String model, String brand){
        return new VehicleFeatures(licensePlate, model, brand);
    }

    private VehicleFeatures(String licensePlate, String model, String brand) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
    }
}
