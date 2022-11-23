package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.controller;

import com.uco.graduationproject.burstcar.application.service.vehiclefeature.consult.ServiceApplicationFindVehicleFeature;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.consult.ServiceApplicationListVehicleFeature;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/vehicle/feature")
public class ConsultControllerVehicleFeature {

    private final ServiceApplicationFindVehicleFeature serviceApplicationFindVehicleFeature;
    private final ServiceApplicationListVehicleFeature serviceApplicationListVehicleFeature;

    public ConsultControllerVehicleFeature(ServiceApplicationFindVehicleFeature serviceApplicationFindVehicleFeature, ServiceApplicationListVehicleFeature serviceApplicationListVehicleFeature) {
        this.serviceApplicationFindVehicleFeature = serviceApplicationFindVehicleFeature;
        this.serviceApplicationListVehicleFeature = serviceApplicationListVehicleFeature;
    }

    @GetMapping("/{licensePlate}")
    public VehicleFeatures findVehicleFeature(@PathVariable ("licensePlate") String licensePlate){
        return this.serviceApplicationFindVehicleFeature.execute(licensePlate);
    }

    @GetMapping("/all")
    public List<VehicleFeatures> listVehicleFeature(){
        return this.serviceApplicationListVehicleFeature.executeList();
    }
}
