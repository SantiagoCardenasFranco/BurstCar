package com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.adapter.entity;

import com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.entity.EntityVehicleFeatures;
import com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity.EntityVehicleService;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class EntityVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "features_id", unique = true)
    private EntityVehicleFeatures entityVehicleFeatures;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private EntityVehicleService entityVehicleService;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    private EntityUser entityUser;

    @Column(name = "enabled")
    private boolean isEnable;

    public EntityVehicle(EntityVehicleFeatures entityVehicleFeatures, EntityVehicleService entityVehicleService, EntityUser entityUser, boolean isEnable) {
        this.entityVehicleFeatures = entityVehicleFeatures;
        this.entityVehicleService = entityVehicleService;
        this.entityUser = entityUser;
        this.isEnable = isEnable;
    }

    public EntityVehicle() {
    }
}
