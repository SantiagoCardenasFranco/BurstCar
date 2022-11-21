package com.uco.graduationproject.burstcar.infrastructure.mapper.vehicleservice.impl;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.infrastructure.mapper.MapperInfrastructureObject;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity.EntityVehicleService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityToDomainServicesImpl implements MapperInfrastructureObject<EntityVehicleService, VehicleService> {
    @Override
    public VehicleService mapperUserToDomain(EntityVehicleService entity) {
        return VehicleService.of(entity.getNameService(), entity.getDescriptionService());
    }

    @Override
    public EntityVehicleService mapperUserToEntity(VehicleService domain) {
        return new EntityVehicleService(domain.getNameService(), domain.getDescriptionService());
    }
}
