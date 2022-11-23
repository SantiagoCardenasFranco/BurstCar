package com.uco.graduationproject.burstcar.application.service.user.comand;

import com.uco.graduationproject.burstcar.application.encrypted.ServiceEncryptedPassword;
import com.uco.graduationproject.burstcar.application.mapper.user.impl.MapperUserApplicationImpl;
import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceSaveUser;
import com.uco.graduationproject.burstcar.domain.validator.ValidatorAttributes;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveUser {

    private final ServiceSaveUser serviceSaveUser;
    private final MapperUserApplicationImpl mapperObjectApplication;
    private final ServiceEncryptedPassword serviceEncryptedPassword;
    public ServiceApplicationSaveUser(ServiceSaveUser serviceSaveUser, MapperUserApplicationImpl mapperObjectApplication, ServiceEncryptedPassword serviceEncryptedPassword) {
        this.serviceSaveUser = serviceSaveUser;
        this.mapperObjectApplication = mapperObjectApplication;
        this.serviceEncryptedPassword = serviceEncryptedPassword;
    }

    public Long execute(DtoSaveUser dto){
        ValidatorAttributes.specialCharactersPassword(dto.getPassword(), "La contarseña no es permitida");
        dto.setPassword(this.serviceEncryptedPassword.execute(dto.getPassword()));
        return this.serviceSaveUser.executeSave(this.mapperObjectApplication.mapperUserToDomain(dto));
    }

}
