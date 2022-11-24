package com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.entity.EntityVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryVehicleJpa extends JpaRepository<EntityVehicle, Long> {
    @Query(value = "Select * From vehicle where vehicle.user_id = :user_id", nativeQuery = true)
    EntityVehicle findByIdUser(@Param("user_id") Long id);

    @Query(value = "Select * From vehicle where vehicle.enabled = :enabled and " +
            "vehicle.service_id = :service_id" , nativeQuery = true)
    List<EntityVehicle> findByServiceAndEnabled(@Param("enabled") boolean bool,
                                            @Param("service_id")Long service );
}
