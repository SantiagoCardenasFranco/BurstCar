package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.validator.ValidatorAttributes;
import com.uco.graduationproject.burstcar.domain.validator.ValidatorObjects;
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
        ValidatorAttributes.validateRequired(identification, "La identificación no puede ser nula");
        ValidatorAttributes.validateRequired(name, "El nombre del usuraio no puede ser nulo");
        ValidatorAttributes.validateRequired(name, "El apellido del usuraio no puede ser nulo");
        ValidatorAttributes.validateRequired(name, "El email del usuraio no puede ser nulo");
        ValidatorAttributes.validateRequired(name, "La contraseña del usuraio no puede ser nulo");
        ValidatorAttributes.noEmpty(rols, "Un usuario siempre debe tenr un rol");
        ValidatorAttributes.specialCharactersEmail(email, "El email no corresponde con una buena escritura");
        ValidatorAttributes.specialCharactersPassword(password, "La contarseña no es permitida");
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
