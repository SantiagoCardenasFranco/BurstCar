package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;

@Getter
public class Vehicle {

    private final VehicleFeatures vehicleFeatures;
    private final VehicleService vehicleService;
    private final User user;
    private final boolean isEnable;

    public static Vehicle of(VehicleFeatures vehicleFeatures, VehicleService vehicleService, User user, boolean isEnable){
        return new Vehicle(vehicleFeatures, vehicleService, user, isEnable);
    }

    private Vehicle(VehicleFeatures vehicleFeatures, VehicleService vehicleService, User user, boolean isEnable) {
        this.vehicleFeatures = vehicleFeatures;
        this.vehicleService = vehicleService;
        this.user = user;
        this.isEnable = isEnable;
    }
}
