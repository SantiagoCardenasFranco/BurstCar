package com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.controller;

import com.uco.graduationproject.burstcar.application.service.vehicle.comand.ServiceApplicationSaveVehicle;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle_user")
public class ComandControllerVehicle {

    private final ServiceApplicationSaveVehicle serviceApplicationSaveVehicle;

    public ComandControllerVehicle(ServiceApplicationSaveVehicle serviceApplicationSaveVehicle) {
        this.serviceApplicationSaveVehicle = serviceApplicationSaveVehicle;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveVehicle(@RequestBody DtoSaveVehicle dto){
        return this.serviceApplicationSaveVehicle.execute(dto);
    }

}
