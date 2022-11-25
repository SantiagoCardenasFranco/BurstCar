package com.uco.graduationproject.burstcar.domain.testdatabuilder.model;


import com.uco.graduationproject.burstcar.domain.model.*;

public class VehicleTestDataBuilder {

    private VehicleFeatures vehicleFeatures;
    private VehicleService vehicleService;
    private User user;
    private boolean isEnable;

    public VehicleTestDataBuilder byDefault() {
        this.vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();
        this.vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();
        this.user = new UserTestDataBuilder().byDefault().build();
        this.isEnable = false;
        return this;
    }

    public VehicleTestDataBuilder withVehicleFeatures(VehicleFeatures vehicleFeatures){
        this.vehicleFeatures = vehicleFeatures;
        return this;
    }

    public VehicleTestDataBuilder withVehicleService(VehicleService vehicleService){
        this.vehicleService = vehicleService;
        return this;
    }

    public VehicleTestDataBuilder withUser(User user){
        this.user = user;
        return this;
    }

    public VehicleTestDataBuilder withEnable(boolean isEnable){
        this.isEnable = isEnable;
        return this;
    }

    public Vehicle build(){
        return Vehicle.of(vehicleFeatures, vehicleService, user, isEnable);
    }
}
