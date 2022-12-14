package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;

public class ServiceSaveUser {

    private final RepositoryUser repositoryUser;

    public ServiceSaveUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public Long executeSave(User user){
        if(!this.repositoryUser.existUser(user)){
            return this.repositoryUser.saveUser(user);
        }
        throw new IllegalArgumentException("Ya existe un usuario, favor de ingresar uno nuevo");
    }
}
