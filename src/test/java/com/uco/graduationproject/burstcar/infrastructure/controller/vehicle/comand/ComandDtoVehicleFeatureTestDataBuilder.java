package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.comand;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;

public class ComandDtoVehicleFeatureTestDataBuilder {

    private String licensePlate;
    private String model;
    private String brand;

    public ComandDtoVehicleFeatureTestDataBuilder byDefault() {
        this.licensePlate = "LSM-65P";
        this.model = "2018";
        this.brand = "Mazda";
        return this;
    }

    public VehicleFeatures build() {
        return VehicleFeatures.of(licensePlate, model, brand);
    }
}
