package com.uco.graduationproject.burstcar.application.user.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceFindUser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceApplicationFindUser {

    private final ServiceFindUser serviceFindUser;

    public ServiceApplicationFindUser(ServiceFindUser serviceFindUser) {
        this.serviceFindUser = serviceFindUser;
    }

    public DtoUserSummary execute(String identification){
        return this.serviceFindUser.executeFind(identification);
    }
}
