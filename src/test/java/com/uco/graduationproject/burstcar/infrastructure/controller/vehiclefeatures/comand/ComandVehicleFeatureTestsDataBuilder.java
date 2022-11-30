package com.uco.graduationproject.burstcar.infrastructure.controller.vehiclefeatures.comand;

import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.dto.DtoSaveVehicleFeature;

public class ComandVehicleFeatureTestsDataBuilder {

    private String licensePlate;
    private String model;
    private String brand;

    public ComandVehicleFeatureTestsDataBuilder byDefault() {
        this.licensePlate = "QRD-98H";
        this.model = "2022";
        this.brand = "Mercedez";
        return this;
    }

    public ComandVehicleFeatureTestsDataBuilder withLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
        return this;
    }

    public ComandVehicleFeatureTestsDataBuilder withModel(String model){
        this.model = model;
        return this;
    }

    public ComandVehicleFeatureTestsDataBuilder withBrand(String brand){
        this.brand = brand;
        return this;
    }

    public DtoSaveVehicleFeature build() {
        return new DtoSaveVehicleFeature(licensePlate, model, brand);
    }
}
