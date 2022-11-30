package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.comand;

import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicle;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;

public class ComandVehicleTestsDataBuilder {

    private VehicleFeatures vehicleFeatures;
    private DtoSaveVehicleService dtoSaveVehicleService;
    private User user;

    public ComandVehicleTestsDataBuilder byDefault() {
        this.vehicleFeatures = new ComandDtoVehicleFeatureTestDataBuilder().byDefault().build();
        this.dtoSaveVehicleService = new ComandDtoVehicleService().byDefault().build();
        this.user = new ComandUserTestDataBuilder().byDefault().build();
        return this;
    }

    public DtoSaveVehicle build() {
        return new DtoSaveVehicle(vehicleFeatures, dtoSaveVehicleService, user);
    }
}
