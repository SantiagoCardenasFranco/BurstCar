package com.uco.graduationproject.burstcar.domain.model;

import lombok.Getter;
import java.util.List;

@Getter
public class User {

    private final String identification;
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;
    private final List<Rol> rols;

    public static User of(String identification, String name, String lastName, String email, String password,
                          List<Rol> rols){

      return new User(identification, name, lastName, email, password, rols);
    }
    private User(String identification, String name, String lastName, String email, String password, List<Rol> rols) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rols = rols;
    }
}
