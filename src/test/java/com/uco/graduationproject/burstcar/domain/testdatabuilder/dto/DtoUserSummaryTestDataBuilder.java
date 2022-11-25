package com.uco.graduationproject.burstcar.domain.testdatabuilder.dto;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.RolTestDataBuilder;

import java.util.Collections;
import java.util.List;

public class DtoUserSummaryTestDataBuilder {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private List<Rol> rols;

    public DtoUserSummaryTestDataBuilder byDefault() {
        Rol rol = new RolTestDataBuilder().byDefault().build();
        List<Rol> roles = Collections.singletonList(rol);

        this.identification = "1234567890";
        this.name = "Nombre";
        this.lastName = "Apellido";
        this.email = "algo@gmail.com";
        this.rols = roles;
        return this;
    }

    public DtoUserSummaryTestDataBuilder withIdentification(String identification){
        this.identification = identification;
        return this;
    }

    public DtoUserSummaryTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public DtoUserSummaryTestDataBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public DtoUserSummaryTestDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }


    public DtoUserSummaryTestDataBuilder withRols(List<Rol> rols){
        this.rols = rols;
        return this;
    }

    public DtoUserSummary build() {
        return new DtoUserSummary(identification, name, lastName, email, rols);
    }
}
