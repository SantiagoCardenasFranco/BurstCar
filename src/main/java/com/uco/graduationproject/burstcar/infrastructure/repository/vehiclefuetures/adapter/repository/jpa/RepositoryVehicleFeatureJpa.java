package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.entity.EntityVehicleFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehicleFeatureJpa extends JpaRepository<EntityVehicleFeatures, Long> {

    EntityVehicleFeatures findByLicensePlate(String licensePlate);
}
