package com.uco.graduationproject.burstcar.domain.dto;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DtoUserSummary {

    private String identification;
    private String name;
    private String lastName;
    private String email;
    private List<Rol> rols;
}
