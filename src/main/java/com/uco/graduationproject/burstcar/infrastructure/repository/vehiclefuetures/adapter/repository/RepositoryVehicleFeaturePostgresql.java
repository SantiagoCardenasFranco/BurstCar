package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.repository;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import com.uco.graduationproject.burstcar.infrastructure.mapper.vehiclefeature.impl.EntityToDomainFeaturesImpl;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.repository.jpa.RepositoryVehicleFeatureJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryVehicleFeaturePostgresql implements RepositoryVehicleFeature {

    private final RepositoryVehicleFeatureJpa repositoryVehicleFeatureJpa;
    private final EntityToDomainFeaturesImpl entityToDomainFeatures;

    public RepositoryVehicleFeaturePostgresql(RepositoryVehicleFeatureJpa repositoryVehicleFeatureJpa, EntityToDomainFeaturesImpl entityToDomainFeatures) {
        this.repositoryVehicleFeatureJpa = repositoryVehicleFeatureJpa;
        this.entityToDomainFeatures = entityToDomainFeatures;
    }

    @Override
    public Long saveFeature(VehicleFeatures vehicleFeatures) {
        return this.repositoryVehicleFeatureJpa.save(this.entityToDomainFeatures.
                mapperUserToEntity(vehicleFeatures)).getId();
    }

    @Override
    public boolean existsFeature(VehicleFeatures vehicleFeatures) {
        return false;
    }

    @Override
    public Boolean updateFeature(Long id, VehicleFeatures vehicleFeatures) {
        return null;
    }

    @Override
    public VehicleFeatures findFeatures(String licensePlate) {
        return this.entityToDomainFeatures.mapperUserToDomain(this.repositoryVehicleFeatureJpa.
                findByLicensePlate(licensePlate));
    }
}
