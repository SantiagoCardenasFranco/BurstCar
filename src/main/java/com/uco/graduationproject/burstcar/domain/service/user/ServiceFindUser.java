package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;

public class ServiceFindUser {

    private final RepositoryUser repositoryUser;

    public ServiceFindUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public DtoUserSummary executeFind(String identification){
        DtoUserSummary dtoUserSummary = this.repositoryUser.consultByIdentification(identification);
        if(dtoUserSummary != null){
            return dtoUserSummary;
        }
        throw new IllegalArgumentException("No se encontró a ningún usuario");
    }
}
