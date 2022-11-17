package com.uco.graduationproject.burstcar.application.user.comand;

import com.uco.graduationproject.burstcar.application.mapper.user.impl.MapperUserApplicationImpl;
import com.uco.graduationproject.burstcar.application.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceSaveUser;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveUser {

    private final ServiceSaveUser serviceSaveUser;
    private final MapperUserApplicationImpl mapperObjectApplication;
    public ServiceApplicationSaveUser(ServiceSaveUser serviceSaveUser, MapperUserApplicationImpl mapperObjectApplication) {
        this.serviceSaveUser = serviceSaveUser;
        this.mapperObjectApplication = mapperObjectApplication;
    }

    public Long execute(DtoSaveUser dto){
        return this.serviceSaveUser.executeSave(this.mapperObjectApplication.mapperUserToDomain(dto));
    }

}
