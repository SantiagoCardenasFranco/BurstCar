package com.uco.graduationproject.burstcar.application.mapper.vehicleservice.impl;

import com.uco.graduationproject.burstcar.application.mapper.MapperObjectApplication;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperVehicleServiceApplicationImpl implements MapperObjectApplication<DtoSaveVehicleService, VehicleService> {


    @Override
    public VehicleService mapperUserToDomain(DtoSaveVehicleService dtoSaveVehicleService) {
        return VehicleService.of(dtoSaveVehicleService.getNameService(), dtoSaveVehicleService.getDescriptionService());
    }

    @Override
    public DtoSaveVehicleService mapperUserToDto(VehicleService domain) {
        return new DtoSaveVehicleService(domain.getNameService(), domain.getDescriptionService());
    }
}
