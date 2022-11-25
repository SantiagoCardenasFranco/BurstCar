package com.uco.graduationproject.burstcar.domain.testdatabuilder.model;


import com.uco.graduationproject.burstcar.domain.model.Rol;

public class RolTestDataBuilder {

    private String  name;
    private String description;

    public RolTestDataBuilder byDefault() {
        this.name = "Cliente";
        this.description = "Encargado de solicitar el servicio de algún conductor disponible";
        return this;
    }

    public RolTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public RolTestDataBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public Rol build(){
        return Rol.of(name, description);
    }
}
