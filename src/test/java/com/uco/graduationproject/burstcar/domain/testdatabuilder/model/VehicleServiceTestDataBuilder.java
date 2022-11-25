package com.uco.graduationproject.burstcar.domain.testdatabuilder.model;


import com.uco.graduationproject.burstcar.domain.model.VehicleService;

public class VehicleServiceTestDataBuilder {

    private String nameService;
    private String descriptionService;

    public VehicleServiceTestDataBuilder byDefault() {
        this.nameService = "Carga";
        this.descriptionService = "Encargado de llevar las cosas seguras de un lugar a otro";
        return this;
    }

    public VehicleServiceTestDataBuilder withName(String nameService){
        this.nameService = nameService;
        return this;
    }

    public VehicleServiceTestDataBuilder withDescription(String descriptionService){
        this.descriptionService = descriptionService;
        return this;
    }

    public VehicleService build(){
        return VehicleService.of(nameService, descriptionService);
    }
}
