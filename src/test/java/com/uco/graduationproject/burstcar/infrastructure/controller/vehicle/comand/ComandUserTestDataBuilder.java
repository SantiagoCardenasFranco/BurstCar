package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.comand;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.RolTestDataBuilder;

import java.util.Collections;
import java.util.List;

public class ComandUserTestDataBuilder {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<Rol> rols;

    public ComandUserTestDataBuilder byDefault() {
        Rol rol = new RolTestDataBuilder().byDefault().build();
        List<Rol> roles = Collections.singletonList(rol);

        this.identification = "7846708";
        this.name = "nombre";
        this.lastName = "Algo";
        this.email = "correo@gmail.com";
        this.password = "w5Mnpo<code>t0d0";
        this.rols = roles;
        return this;
    }

    public ComandUserTestDataBuilder withIdentification(String identification){
        this.identification = identification;
        return this;
    }

    public ComandUserTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ComandUserTestDataBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public ComandUserTestDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }


    public ComandUserTestDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public ComandUserTestDataBuilder withRols(List<Rol> rols){
        this.rols = rols;
        return this;
    }

    public User build() {
        return User.of(identification, name, lastName, email, password, rols);
    }
}
