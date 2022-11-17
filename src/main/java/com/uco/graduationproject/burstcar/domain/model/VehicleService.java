package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.validator.ValidatorAttributes;
import lombok.Getter;

@Getter
public class VehicleService {

    private final String nameService;
    private final String descriptionService;

    public static VehicleService of(String nameService, String descriptionService){
        ValidatorAttributes.validateRequired(nameService, "Un servicio siempre debe tenr un nombre");
        ValidatorAttributes.validateRequired(descriptionService, "Un servicio siempre debe tener una descripción");
        return new VehicleService(nameService, descriptionService);
    }

    private VehicleService(String nameService, String descriptionService) {
        this.nameService = nameService;
        this.descriptionService = descriptionService;
    }
}
