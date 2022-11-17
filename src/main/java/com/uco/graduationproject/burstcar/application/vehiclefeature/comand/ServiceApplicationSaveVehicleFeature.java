package com.uco.graduationproject.burstcar.application.vehiclefeature.comand;

import com.uco.graduationproject.burstcar.application.mapper.vehiclefeature.impl.MapperVehicleFeatureApplicationImpl;
import com.uco.graduationproject.burstcar.application.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceSaveVehicleFeature;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveVehicleFeature {

    private final ServiceSaveVehicleFeature serviceSaveVehicleFeature;
    private final MapperVehicleFeatureApplicationImpl mapperVehicleFeatureApplication;

    public ServiceApplicationSaveVehicleFeature(ServiceSaveVehicleFeature serviceSaveVehicleFeature, MapperVehicleFeatureApplicationImpl mapperVehicleFeatureApplication) {
        this.serviceSaveVehicleFeature = serviceSaveVehicleFeature;
        this.mapperVehicleFeatureApplication = mapperVehicleFeatureApplication;
    }

    public Long execute(DtoSaveVehicleFeature dto){
        return this.serviceSaveVehicleFeature.executeSave(
                this.mapperVehicleFeatureApplication.mapperUserToDomain(dto));
    }

}
