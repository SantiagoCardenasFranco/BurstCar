package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.controller;

import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.ServiceApplicationSaveVehicleFeature;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.ServiceApplicationUpdateVehicleFeature;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle/feature")
public class ComandControllerVehicleFeature {

    private final ServiceApplicationSaveVehicleFeature serviceApplicationSaveVehicleFeature;
    private final ServiceApplicationUpdateVehicleFeature serviceApplicationUpdateVehicleFeature;

    public ComandControllerVehicleFeature(ServiceApplicationSaveVehicleFeature serviceApplicationSaveVehicleFeature, ServiceApplicationUpdateVehicleFeature serviceApplicationUpdateVehicleFeature) {
        this.serviceApplicationSaveVehicleFeature = serviceApplicationSaveVehicleFeature;
        this.serviceApplicationUpdateVehicleFeature = serviceApplicationUpdateVehicleFeature;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveVehicleFeature(@RequestBody DtoSaveVehicleFeature dto){
        return this.serviceApplicationSaveVehicleFeature.execute(dto);
    }

    @PutMapping("/update/{id}")
    public void updateVehicleFeature(@PathVariable("id") Long id, @RequestBody DtoSaveVehicleFeature dto){
        this.serviceApplicationUpdateVehicleFeature.execute(id, dto);
    }
}
