package com.uco.graduationproject.burstcar.infrastructure.mapper.vehiclefeature.impl;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.infrastructure.mapper.MapperInfrastructureObject;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.entity.EntityVehicleFeatures;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityToDomainFeaturesImpl implements MapperInfrastructureObject<EntityVehicleFeatures, VehicleFeatures> {
    @Override
    public VehicleFeatures mapperUserToDomain(EntityVehicleFeatures entity) {
        return VehicleFeatures.of(entity.getLicensePlate(), entity.getModel(), entity.getBrand());
    }

    @Override
    public EntityVehicleFeatures mapperUserToEntity(VehicleFeatures domain) {
        return new EntityVehicleFeatures(domain.getLicensePlate(), domain.getModel(), domain.getBrand());
    }
}
