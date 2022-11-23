package com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand;

import com.uco.graduationproject.burstcar.application.mapper.vehiclefeature.impl.MapperVehicleFeatureApplicationImpl;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceUpdateVehicleFeature;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationUpdateVehicleFeature {

    private final ServiceUpdateVehicleFeature serviceUpdateVehicleFeature;
    private final MapperVehicleFeatureApplicationImpl mapperVehicleFeatureApplication;

    public ServiceApplicationUpdateVehicleFeature(ServiceUpdateVehicleFeature serviceUpdateVehicleFeature, MapperVehicleFeatureApplicationImpl mapperVehicleFeatureApplication) {
        this.serviceUpdateVehicleFeature = serviceUpdateVehicleFeature;
        this.mapperVehicleFeatureApplication = mapperVehicleFeatureApplication;
    }

    public void execute(Long id, DtoSaveVehicleFeature dto){
        this.serviceUpdateVehicleFeature.executeUpdate(id,
                this.mapperVehicleFeatureApplication.mapperUserToDomain(dto));
    }
}
