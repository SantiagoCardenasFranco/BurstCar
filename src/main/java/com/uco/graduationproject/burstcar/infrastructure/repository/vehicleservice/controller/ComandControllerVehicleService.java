package com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.controller;

import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.ServiceApplicationSaveVehicleService;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.ServiceApplicationUpdateVehicleService;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle/service")
public class ComandControllerVehicleService {

    private final ServiceApplicationSaveVehicleService serviceApplicationSaveVehicleService;
    private final ServiceApplicationUpdateVehicleService serviceApplicationUpdateVehicleService;

    public ComandControllerVehicleService(ServiceApplicationSaveVehicleService serviceApplicationSaveVehicleService, ServiceApplicationUpdateVehicleService serviceApplicationUpdateVehicleService) {
        this.serviceApplicationSaveVehicleService = serviceApplicationSaveVehicleService;
        this.serviceApplicationUpdateVehicleService = serviceApplicationUpdateVehicleService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveVehicleService(@RequestBody DtoSaveVehicleService dto){
        return this.serviceApplicationSaveVehicleService.execute(dto);
    }

    @PutMapping("/update/{id}")
    public boolean updateVehicleService(@PathVariable("id") Long id, @RequestBody DtoSaveVehicleService dto){
        return this.serviceApplicationUpdateVehicleService.execute(id, dto);
    }
}
