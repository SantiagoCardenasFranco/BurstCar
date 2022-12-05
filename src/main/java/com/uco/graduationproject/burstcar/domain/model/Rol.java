package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.validator.ValidatorAttributes;
import lombok.Getter;

@Getter
public class Rol {

    private final String  name;
    private final String description;

    public static Rol of(String name, String description){
        ValidatorAttributes.validateRequired(name, "Un rol siempre debe tenr un nombre");
        ValidatorAttributes.validateRequired(description, "Un rol siempre debe tener una descripción");
        return new Rol(name, description);
    }

    private Rol(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getRol() {
        return name;
    }
}
