package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;

@Getter
public class Vehicle {

    private final VehicleFeatures vehicleFeatures;
    private final Service vehicleService;
    private final User user;

    public static Vehicle of(VehicleFeatures vehicleFeatures, Service vehicleService, User user){
        return new Vehicle(vehicleFeatures, vehicleService, user);
    }

    private Vehicle(VehicleFeatures vehicleFeatures, Service vehicleService, User user) {
        this.vehicleFeatures = vehicleFeatures;
        this.vehicleService = vehicleService;
        this.user = user;
    }
}
