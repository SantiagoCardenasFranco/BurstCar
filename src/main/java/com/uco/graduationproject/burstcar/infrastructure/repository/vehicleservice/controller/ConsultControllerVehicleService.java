package com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.controller;

import com.uco.graduationproject.burstcar.application.service.vehicleservice.consult.ServiceApplicationListVehicleService;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/vehicle/service")
public class ConsultControllerVehicleService {

    private final ServiceApplicationListVehicleService serviceApplicationListVehicleService;

    public ConsultControllerVehicleService(ServiceApplicationListVehicleService serviceApplicationListVehicleService) {
        this.serviceApplicationListVehicleService = serviceApplicationListVehicleService;
    }

    @GetMapping("/all")
    public List<VehicleService> listVehicleService(){
        return this.serviceApplicationListVehicleService.execute();
    }
}
