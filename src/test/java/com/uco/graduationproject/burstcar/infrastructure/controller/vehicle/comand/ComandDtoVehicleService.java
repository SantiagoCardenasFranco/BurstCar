package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.comand;

import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicleService;

public class ComandDtoVehicleService {

    private String nameService;

    public ComandDtoVehicleService byDefault() {
        this.nameService = "Carga";
        return this;
    }

    public DtoSaveVehicleService build(){
        return new DtoSaveVehicleService(nameService);
    }
}
