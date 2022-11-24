package com.uco.graduationproject.burstcar.infrastructure.mapper.vehicle.impl;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.infrastructure.mapper.MapperInfrastructureObject;
import com.uco.graduationproject.burstcar.infrastructure.mapper.user.impl.EntityToDomainImpl;
import com.uco.graduationproject.burstcar.infrastructure.mapper.vehiclefeature.impl.EntityToDomainFeaturesImpl;
import com.uco.graduationproject.burstcar.infrastructure.mapper.vehicleservice.impl.EntityToDomainServicesImpl;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.entity.EntityVehicle;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityToDomainVehicleImpl implements MapperInfrastructureObject<EntityVehicle, Vehicle> {

    private final EntityToDomainFeaturesImpl entityToDomainFeatures;
    private final EntityToDomainServicesImpl entityToDomainServices;
    private final EntityToDomainImpl entityToDomain;

    public EntityToDomainVehicleImpl(EntityToDomainFeaturesImpl entityToDomainFeatures, EntityToDomainServicesImpl entityToDomainServices, EntityToDomainImpl entityToDomain) {
        this.entityToDomainFeatures = entityToDomainFeatures;
        this.entityToDomainServices = entityToDomainServices;
        this.entityToDomain = entityToDomain;
    }

    @Override
    public Vehicle mapperUserToDomain(EntityVehicle entity) {
        return Vehicle.of(this.entityToDomainFeatures.mapperUserToDomain(entity.getEntityVehicleFeatures()),
                this.entityToDomainServices.mapperUserToDomain(entity.getEntityVehicleService()),
                this.entityToDomain.mapperUserToDomain(entity.getEntityUser()), entity.isEnable());
    }

    @Override
    public EntityVehicle mapperUserToEntity(Vehicle domain) {
        return new EntityVehicle(this.entityToDomainFeatures.mapperUserToEntity(domain.getVehicleFeatures()),
                this.entityToDomainServices.mapperUserToEntity(domain.getVehicleService()),
                this.entityToDomain.mapperUserToEntity(domain.getUser()), domain.isEnable());
    }

    public DtoVehicleSummary mapperUserToDtoSummary(EntityVehicle entity){
        return new DtoVehicleSummary(this.entityToDomainFeatures.mapperUserToDomain(entity.getEntityVehicleFeatures()),
                this.entityToDomainServices.mapperUserToDomain(entity.getEntityVehicleService()),
                this.entityToDomain.mapperUserToDtoSummary(entity.getEntityUser()), entity.isEnable());
    }
}
