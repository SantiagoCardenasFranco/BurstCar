package com.uco.graduationproject.burstcar.domain.service.vehicle;

import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;

public class ServiceSaveVehicle {

    private final RepositoryVehicle repositoryVehicle;

    public ServiceSaveVehicle(RepositoryVehicle repositoryVehicle) {
        this.repositoryVehicle = repositoryVehicle;
    }

    public Long executeSave(Vehicle vehicle){
        return this.repositoryVehicle.saveVehicle(vehicle);
    }
}
