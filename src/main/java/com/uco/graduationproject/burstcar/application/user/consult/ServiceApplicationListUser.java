package com.uco.graduationproject.burstcar.application.user.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationListUser {

    private final RepositoryUser repositoryUser;

    public ServiceApplicationListUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public List<DtoUserSummary> execute(){
        return this.repositoryUser.listUser();
    }
}
