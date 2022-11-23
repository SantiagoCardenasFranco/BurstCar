package com.uco.graduationproject.burstcar.domain.service.vehiclefeature;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;

public class ServiceSaveVehicleFeature {

    private final RepositoryVehicleFeature repositoryVehicleFeature;

    public ServiceSaveVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature) {
        this.repositoryVehicleFeature = repositoryVehicleFeature;
    }

    public Long executeSave(VehicleFeatures vehicleFeatures){
        if(!this.repositoryVehicleFeature.existsFeature(vehicleFeatures)){
            return this.repositoryVehicleFeature.saveFeature(vehicleFeatures);
        }
        throw new IllegalArgumentException("Estas castacteristicas de su vehiculo es muy parecida a una que ya está " +
                "registrada, por favor ingrese de nuevo los datos");
    }
}
