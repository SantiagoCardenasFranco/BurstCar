package com.uco.graduationproject.burstcar.application.vehiclefeature.consult;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationFindVehicleFeature {

    private final RepositoryVehicleFeature repositoryVehicleFeature;

    public ServiceApplicationFindVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature) {
        this.repositoryVehicleFeature = repositoryVehicleFeature;
    }

    public VehicleFeatures execute(String licensePlate){
        return this.repositoryVehicleFeature.findFeatures(licensePlate);
    }
}
