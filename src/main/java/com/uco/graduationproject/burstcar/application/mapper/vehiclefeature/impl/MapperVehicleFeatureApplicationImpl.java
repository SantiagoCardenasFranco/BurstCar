package com.uco.graduationproject.burstcar.application.mapper.vehiclefeature.impl;

import com.uco.graduationproject.burstcar.application.mapper.MapperObjectApplication;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperVehicleFeatureApplicationImpl implements MapperObjectApplication<DtoSaveVehicleFeature, VehicleFeatures> {

    @Override
    public VehicleFeatures mapperUserToDomain(DtoSaveVehicleFeature dtoSaveVehicleFeature) {
        return VehicleFeatures.of(dtoSaveVehicleFeature.getLicensePlate(), dtoSaveVehicleFeature.getModel(),
                dtoSaveVehicleFeature.getBrand());
    }
}
