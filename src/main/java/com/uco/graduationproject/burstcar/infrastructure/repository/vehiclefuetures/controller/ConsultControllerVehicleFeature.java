package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.controller;

import com.uco.graduationproject.burstcar.application.vehiclefeature.consult.ServiceApplicationFindVehicleFeature;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehicle/feature")
public class ConsultControllerVehicleFeature {

    private final ServiceApplicationFindVehicleFeature serviceApplicationFindVehicleFeature;

    public ConsultControllerVehicleFeature(ServiceApplicationFindVehicleFeature serviceApplicationFindVehicleFeature) {
        this.serviceApplicationFindVehicleFeature = serviceApplicationFindVehicleFeature;
    }

    @GetMapping("/{licensePlate}")
    public VehicleFeatures findVehicleFeature(@PathVariable ("licensePlate") String licensePlate){
        return this.serviceApplicationFindVehicleFeature.execute(licensePlate);
    }
}
