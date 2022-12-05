package com.uco.graduationproject.burstcar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DtoUserCurrent {
    private String user;
    private List<String> roles;

}
