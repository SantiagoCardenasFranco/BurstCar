package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveUser {

    private final RepositoryUser repositoryUser;

    public ServiceSaveUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public Long executeSave(User user){
        return this.repositoryUser.saveUser(user);
    }
}
