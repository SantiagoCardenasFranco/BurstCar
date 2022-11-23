package com.uco.graduationproject.burstcar.application.service.user.comand.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoSaveUser {
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<DtoRol> roles;


}
