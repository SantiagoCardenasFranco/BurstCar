package com.uco.graduationproject.burstcar.application.mapper.vehicle.impl;

import com.uco.graduationproject.burstcar.application.mapper.MapperObjectApplication;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicle;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperVehicleApplicationImpl implements MapperObjectApplication<DtoSaveVehicle, Vehicle> {

    private final RepositoryService repositoryService;

    public MapperVehicleApplicationImpl(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public Vehicle mapperUserToDomain(DtoSaveVehicle dtoSaveVehicle) {
        return Vehicle.of(dtoSaveVehicle.getVehicleFeatures(),
                this.repositoryService.findByName(dtoSaveVehicle.getDtoSaveVehicleService().getNameService()),
                dtoSaveVehicle.getUser(), false);
    }

    @Override
    public DtoSaveVehicle mapperUserToDto(Vehicle domain) {
        return new DtoSaveVehicle(domain.getVehicleFeatures(),
                new DtoSaveVehicleService(domain.getVehicleService().getNameService()),
                domain.getUser());
    }
}
