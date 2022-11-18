package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;


public class ServiceUpdateUser {

    private final RepositoryUser repositoryUser;

    public ServiceUpdateUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public void executeUpdate(Long id, User user){
        validatorExist(user);
        this.repositoryUser.updateUser(id, user);
    }

    private void validatorExist(User user){
        if(!this.repositoryUser.existUser(user)){
            throw new IllegalArgumentException("No existe ese usuario");
        }
    }
}
