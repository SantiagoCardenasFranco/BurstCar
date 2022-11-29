package com.uco.graduationproject.burstcar.infrastructure.controller.user.comand;

import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoRol;
import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoSaveUser;

import java.util.ArrayList;
import java.util.List;

public class ComandUserTestsDataBuilder {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<DtoRol> roles;

    public ComandUserTestsDataBuilder byDefault() {
        List<DtoRol> roles = new ArrayList<>();
        roles.add(new ComandRolTestDataBuilder().byDefault().build());

        this.identification = "12435678";
        this.name = "Nombre";
        this.lastName = "Apellido";
        this.email = "aqui12@gmail.com";
        this.password = "w9Inpo<code>t0d0";
        this.roles = roles;
        return this;
    }

    public ComandUserTestsDataBuilder withIdentification(String identification){
        this.identification = identification;
        return this;
    }

    public ComandUserTestsDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ComandUserTestsDataBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public ComandUserTestsDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }


    public ComandUserTestsDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public ComandUserTestsDataBuilder withRols(List<DtoRol> roles){
        this.roles = roles;
        return this;
    }

    public DtoSaveUser build() {
        return new DtoSaveUser(identification, name, lastName, email, password, roles);
    }
}
