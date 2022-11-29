package com.uco.graduationproject.burstcar.infrastructure.controller.vehicleservice.comand;

import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;

public class ComandVehicleServiceTestsDataBuilder {

    private String nameService;
    private String descriptionService;

    public ComandVehicleServiceTestsDataBuilder byDefault() {
        this.nameService = "Transporte producto";
        this.descriptionService = "Encaragdo de llevar productos de un punto a otro";
        return this;
    }

    public ComandVehicleServiceTestsDataBuilder withNameService(String nameService){
        this.nameService = nameService;
        return this;
    }

    public ComandVehicleServiceTestsDataBuilder withDescriptionService(String descriptionService){
        this.descriptionService = descriptionService;
        return this;
    }

    public DtoSaveVehicleService build() {
        return new DtoSaveVehicleService(nameService, descriptionService);
    }
}
