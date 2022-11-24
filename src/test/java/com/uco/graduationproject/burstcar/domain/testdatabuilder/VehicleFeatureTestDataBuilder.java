package com.uco.graduationproject.burstcar.domain.testdatabuilder;


import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;

public class VehicleFeatureTestDataBuilder {

    private String licensePlate;
    private String model;
    private String brand;

    public VehicleFeatureTestDataBuilder byDefault() {
        this.licensePlate = "XAS-42A";
        this.model = "2023";
        this.brand = "Chevrolet";
        return this;
    }

    public VehicleFeatureTestDataBuilder withLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
        return this;
    }

    public VehicleFeatureTestDataBuilder withModel(String model){
        this.model = model;
        return this;
    }

    public VehicleFeatureTestDataBuilder withBrand(String brand){
        this.brand = brand;
        return this;
    }

    public VehicleFeatures build(){
        return VehicleFeatures.of(licensePlate, model, brand);
    }
}
