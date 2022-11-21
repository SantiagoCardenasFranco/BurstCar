package com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity.EntityVehicleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehicleServiceJpa extends JpaRepository<EntityVehicleService, Long> {

    EntityVehicleService findByNameService(String nameService);
}
