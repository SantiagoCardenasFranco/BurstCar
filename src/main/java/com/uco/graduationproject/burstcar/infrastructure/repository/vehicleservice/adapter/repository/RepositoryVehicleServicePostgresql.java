package com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.repository;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.infrastructure.mapper.vehicleservice.impl.EntityToDomainServicesImpl;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity.EntityVehicleService;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.repository.jpa.RepositoryVehicleServiceJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryVehicleServicePostgresql implements RepositoryService {

    private final RepositoryVehicleServiceJpa repositoryVehicleFeatureJpa;
    private final EntityToDomainServicesImpl entityToDomainServices;

    public RepositoryVehicleServicePostgresql(RepositoryVehicleServiceJpa repositoryVehicleFeatureJpa, EntityToDomainServicesImpl entityToDomainServices) {
        this.repositoryVehicleFeatureJpa = repositoryVehicleFeatureJpa;
        this.entityToDomainServices = entityToDomainServices;
    }

    @Override
    public List<VehicleService> listService() {
        return this.repositoryVehicleFeatureJpa.findAll().stream().map(
                this.entityToDomainServices::mapperUserToDomain).toList();
    }

    @Override
    public Long save(VehicleService service) {
        return this.repositoryVehicleFeatureJpa.save(this.entityToDomainServices.mapperUserToEntity(service))
                .getId();
    }

    @Override
    public boolean updateService(Long id, VehicleService service) {
        EntityVehicleService entityVehicleService = new EntityVehicleService();
        entityVehicleService.setId(id);
        entityVehicleService.setNameService(service.getNameService());
        entityVehicleService.setDescriptionService(service.getDescriptionService());
        this.repositoryVehicleFeatureJpa.save(entityVehicleService);
        return true;
    }

    @Override
    public boolean existService(String service) {
        return this.repositoryVehicleFeatureJpa.findByNameService(service) != null;
    }

    @Override
    public VehicleService findByName(String name) {
        return this.entityToDomainServices.mapperUserToDomain(
                this.repositoryVehicleFeatureJpa.findByNameService(name));
    }
}
