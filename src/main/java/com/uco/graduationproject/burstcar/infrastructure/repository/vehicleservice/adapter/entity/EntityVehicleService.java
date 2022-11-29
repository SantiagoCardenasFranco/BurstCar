package com.uco.graduationproject.burstcar.infrastructure.repository.vehicleservice.adapter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "vehicle_service")
public class EntityVehicleService {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, length = 20, name = "service")
    private String nameService;

    @Column(name = "description_service")
    private String descriptionService;

    public EntityVehicleService() {
    }

    public EntityVehicleService(String nameService, String descriptionService) {
        this.nameService = nameService;
        this.descriptionService = descriptionService;
    }
}
