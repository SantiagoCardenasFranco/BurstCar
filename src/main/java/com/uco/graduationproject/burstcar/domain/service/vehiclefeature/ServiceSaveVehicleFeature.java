package com.uco.graduationproject.burstcar.domain.service.vehiclefeature;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;

public class ServiceSaveVehicleFeature {

    private final RepositoryVehicleFeature repositoryVehicleFeature;

    public ServiceSaveVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature) {
        this.repositoryVehicleFeature = repositoryVehicleFeature;
    }

    public Long executeSave(VehicleFeatures vehicleFeatures){
        return this.repositoryVehicleFeature.saveFeature(vehicleFeatures);
    }
}
