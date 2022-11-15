package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;

@Getter
public class Rol {

    private final String  name;
    private final String description;

    public static Rol of(String name, String description){
        return new Rol(name, description);
    }

    private Rol(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
