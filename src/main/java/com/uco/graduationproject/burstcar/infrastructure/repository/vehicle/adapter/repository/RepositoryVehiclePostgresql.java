package com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.repository;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.infrastructure.mapper.vehicle.impl.EntityToDomainVehicleImpl;
import com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.repository.jpa.RepositoryUserJpa;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.entity.EntityVehicle;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.repository.jpa.RepositoryVehicleJpa;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.entity.EntityVehicleFeatures;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.repository.jpa.RepositoryVehicleFeatureJpa;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity.EntityVehicleService;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.repository.jpa.RepositoryVehicleServiceJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryVehiclePostgresql implements RepositoryVehicle {

    private final RepositoryVehicleJpa repositoryVehicleJpa;
    private final RepositoryUserJpa repositoryUserJpa;
    private final EntityToDomainVehicleImpl entityToDomainVehicle;
    private final RepositoryVehicleFeatureJpa repositoryVehicleFeatureJpa;
    private final RepositoryVehicleServiceJpa repositoryVehicleServiceJpa;


    public RepositoryVehiclePostgresql(RepositoryVehicleJpa repositoryVehicleJpa, RepositoryUserJpa repositoryUserJpa, EntityToDomainVehicleImpl entityToDomainVehicle, RepositoryVehicleFeatureJpa repositoryVehicleFeatureJpa, RepositoryVehicleServiceJpa repositoryVehicleServiceJpa) {
        this.repositoryVehicleJpa = repositoryVehicleJpa;
        this.repositoryUserJpa = repositoryUserJpa;
        this.entityToDomainVehicle = entityToDomainVehicle;
        this.repositoryVehicleFeatureJpa = repositoryVehicleFeatureJpa;
        this.repositoryVehicleServiceJpa = repositoryVehicleServiceJpa;
    }


    @Override
    public List<DtoVehicleSummary> listVehicle() {
        return this.repositoryVehicleJpa.findAll().stream().map(
                this.entityToDomainVehicle::mapperUserToDtoSummary).toList();
    }

    @Override
    public Long saveVehicle(Vehicle vehicle) {
        EntityVehicleFeatures entityVehicleFeatures = this.repositoryVehicleFeatureJpa.findByLicensePlate(
                vehicle.getVehicleFeatures().getLicensePlate());
        EntityUser entityUser = this.repositoryUserJpa.findByIdentification(vehicle.getUser().getIdentification());
        EntityVehicleService entityVehicleService = this.repositoryVehicleServiceJpa.findByNameService(
                vehicle.getVehicleService().getNameService());


        EntityVehicle entityVehicle = new EntityVehicle(entityVehicleFeatures, entityVehicleService,
                entityUser, false);
        return this.repositoryVehicleJpa.save(entityVehicle).getId();
    }

    @Override
    public DtoVehicleSummary consultByUser(String userIdentification) {
        EntityUser entityUser= this.repositoryUserJpa.findByIdentification(userIdentification);
        EntityVehicle entityVehicle = this.repositoryVehicleJpa.findByIdUser(entityUser.getId());
        return this.entityToDomainVehicle.mapperUserToDtoSummary(
                entityVehicle);
    }

    @Override
    public List<DtoVehicleSummary> consultByServiceAndEnabled(boolean bool, String nameService) {
        EntityVehicleService entityVehicleService = this.repositoryVehicleServiceJpa.findByNameService(
                nameService);
        return this.repositoryVehicleJpa.findByServiceAndEnabled(bool, entityVehicleService.getId()).stream().map(
                this.entityToDomainVehicle::mapperUserToDtoSummary).toList();
    }
}