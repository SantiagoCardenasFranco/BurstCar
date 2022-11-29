package com.uco.graduationproject.burstcar.infrastructure.controller.user.comand;


import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoRol;

public class ComandRolTestDataBuilder {

    private String  name;

    public ComandRolTestDataBuilder byDefault() {
        this.name = "Cliente";
        return this;
    }

    public ComandRolTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }


    public DtoRol build(){
        return new DtoRol(name);
    }
}
