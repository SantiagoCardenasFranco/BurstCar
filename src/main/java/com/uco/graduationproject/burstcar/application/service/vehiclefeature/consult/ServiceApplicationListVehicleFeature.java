package com.uco.graduationproject.burstcar.application.service.vehiclefeature.consult;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationListVehicleFeature {

    private final RepositoryVehicleFeature repositoryVehicleFeature;

    public ServiceApplicationListVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature) {
        this.repositoryVehicleFeature = repositoryVehicleFeature;
    }

    public List<VehicleFeatures> executeList(){
        return this.repositoryVehicleFeature.listFeatures();
    }
}
