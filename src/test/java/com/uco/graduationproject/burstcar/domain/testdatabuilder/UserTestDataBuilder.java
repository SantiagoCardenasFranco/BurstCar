package com.uco.graduationproject.burstcar.domain.testdatabuilder;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;

import java.util.Collections;
import java.util.List;

public class UserTestDataBuilder {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<Rol> rols;

    public UserTestDataBuilder byDefault() {
        Rol rol = new RolTestDataBuilder().byDefault().build();
        List<Rol> roles = Collections.singletonList(rol);

        this.identification = "1234567890";
        this.name = "Nombre";
        this.lastName = "Apellido";
        this.email = "algo@gmail.com";
        this.password = "w9Inpo<code>t0d0";
        this.rols = roles;
        return this;
    }

    public UserTestDataBuilder withIdentification(String identification){
        this.identification = identification;
        return this;
    }

    public UserTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public UserTestDataBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserTestDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }


    public UserTestDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public UserTestDataBuilder withRols(List<Rol> rols){
        this.rols = rols;
        return this;
    }

    public User build() {
        return User.of(identification, name, lastName, email, password, rols);
    }
}
