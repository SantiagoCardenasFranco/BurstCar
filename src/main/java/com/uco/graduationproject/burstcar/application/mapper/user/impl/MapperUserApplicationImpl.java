package com.uco.graduationproject.burstcar.application.mapper.user.impl;

import com.uco.graduationproject.burstcar.application.mapper.MapperObjectApplication;
import com.uco.graduationproject.burstcar.application.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class MapperUserApplicationImpl implements MapperObjectApplication<DtoSaveUser, User> {
    @Override
    public User mapperUserToDomain(DtoSaveUser dtoSaveUser) {
        return User.of(dtoSaveUser.getIdentification(), dtoSaveUser.getName(), dtoSaveUser.getLastName(),
                dtoSaveUser.getEmail(), dtoSaveUser.getPassword(),
                dtoSaveUser.getRoles().stream().map(rol -> Rol.of(rol.getName(),
                        descriptionRol(rol.getName()))).toList());
    }

    @Override
    public DtoSaveUser mapperUserToDto(User domain) {
        return null;
    }

    private String descriptionRol(String name){
        if(Objects.equals(name, "Conductor")){
            return "Encargado de llevar el domicilo seguramente hasta el punto que desee el cliente";
        }
        else if("Cliente".equals(name)){
            return "Encargado de solicitar el servicio de algún conductor disponible";
        }
        throw  new IllegalStateException("El valor es nulo o no es valido, no se puede operar");
    }
}
