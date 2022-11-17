package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.controller;

import com.uco.graduationproject.burstcar.application.vehiclefeature.comand.ServiceApplicationSaveVehicleFeature;
import com.uco.graduationproject.burstcar.application.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle/feature")
public class ComandControllerVehicleFeature {

    private final ServiceApplicationSaveVehicleFeature serviceApplicationSaveVehicleFeature;

    public ComandControllerVehicleFeature(ServiceApplicationSaveVehicleFeature serviceApplicationSaveVehicleFeature) {
        this.serviceApplicationSaveVehicleFeature = serviceApplicationSaveVehicleFeature;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveVehicleFeature(@RequestBody DtoSaveVehicleFeature dto){
        return this.serviceApplicationSaveVehicleFeature.execute(dto);
    }
}
