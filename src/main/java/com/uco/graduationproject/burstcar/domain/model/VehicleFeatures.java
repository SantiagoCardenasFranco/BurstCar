package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.validator.ValidatorAttributes;
import lombok.Getter;

@Getter
public class VehicleFeatures {

    private final String licensePlate;
    private final String model;
    private final String brand;

    public static VehicleFeatures of(String licensePlate, String model, String brand){
        ValidatorAttributes.validateRequired(licensePlate, "Un vehiculo siempre debe tenr matricula");
        ValidatorAttributes.validateRequired(model, "Un vehiculo debe de tener un modelo");
        ValidatorAttributes.validateRequired(brand, "Un vehiculo es de una marca");
        return new VehicleFeatures(licensePlate, model, brand);
    }

    private VehicleFeatures(String licensePlate, String model, String brand) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
    }
}
