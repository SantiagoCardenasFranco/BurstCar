package com.uco.graduationproject.burstcar.domain.dto;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import lombok.Getter;

import java.util.List;

@Getter
public class DtoUserSummary {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private List<Rol> rols;

    public DtoUserSummary() {
    }

    public DtoUserSummary(String identification, String name, String lastName, String email, List<Rol> rols) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.rols = rols;
    }
}
