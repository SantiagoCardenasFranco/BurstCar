package com.uco.graduationproject.burstcar.application.service.user.comand;

import com.uco.graduationproject.burstcar.application.mapper.user.impl.MapperUserApplicationImpl;
import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceUpdateUser;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationUpdateUser {

    private final ServiceUpdateUser serviceUpdateUser;
    private final MapperUserApplicationImpl mapperUserApplication;

    public ServiceApplicationUpdateUser(ServiceUpdateUser serviceUpdateUser, MapperUserApplicationImpl mapperUserApplication) {
        this.serviceUpdateUser = serviceUpdateUser;
        this.mapperUserApplication = mapperUserApplication;
    }

    public void execute(Long id, DtoSaveUser dtoSaveUser){
        this.serviceUpdateUser.executeUpdate(id, this.mapperUserApplication.
                mapperUserToDomain(dtoSaveUser));
    }
}
