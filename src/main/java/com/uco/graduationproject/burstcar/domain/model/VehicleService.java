package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;

@Getter
public class VehicleService {

    private final String nameService;
    private final String descriptionService;

    public static VehicleService of(String nameService, String descriptionService){
        return new VehicleService(nameService, descriptionService);
    }

    private VehicleService(String nameService, String descriptionService) {
        this.nameService = nameService;
        this.descriptionService = descriptionService;
    }
}
