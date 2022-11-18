package com.uco.graduationproject.burstcar.infrastructure.repository.vehiclefuetures.adapter.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vehicle_features")
public class EntityVehicleFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(unique = true, length = 10, name = "license_plate")
    private String licensePlate;

    @Column(length = 10)
    private String model;

    @Column(length = 25)
    private String brand;

    public EntityVehicleFeatures() {
    }

    public EntityVehicleFeatures(String licensePlate, String model, String brand) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
    }
}
