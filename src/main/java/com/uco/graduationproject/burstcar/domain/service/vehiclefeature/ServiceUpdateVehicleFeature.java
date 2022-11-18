package com.uco.graduationproject.burstcar.domain.service.vehiclefeature;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;

public class ServiceUpdateVehicleFeature {

    private final RepositoryVehicleFeature repositoryVehicleFeature;

    public ServiceUpdateVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature) {
        this.repositoryVehicleFeature = repositoryVehicleFeature;
    }

    public void executeUpdate(Long id, VehicleFeatures vehicleFeatures){
        validatorExist(vehicleFeatures);
        this.repositoryVehicleFeature.updateFeature(id, vehicleFeatures);
    }

    private void validatorExist(VehicleFeatures vehicleFeatures){
        if(!this.repositoryVehicleFeature.existsFeature(vehicleFeatures)){
            throw new IllegalArgumentException("No existe ese vehiculo");
        }
    }
}
