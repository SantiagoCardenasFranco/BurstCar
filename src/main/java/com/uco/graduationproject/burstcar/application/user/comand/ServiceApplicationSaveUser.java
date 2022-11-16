package com.uco.graduationproject.burstcar.application.user.comand;

import com.uco.graduationproject.burstcar.application.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceSaveUser;
import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.repository.RepositoryRolPostgresql;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveUser {

    private final ServiceSaveUser serviceSaveUser;
    private final RepositoryRolPostgresql repositoryRolPostgresql;

    public ServiceApplicationSaveUser(ServiceSaveUser serviceSaveUser, RepositoryRolPostgresql repositoryRolPostgresql) {
        this.serviceSaveUser = serviceSaveUser;
        this.repositoryRolPostgresql = repositoryRolPostgresql;
    }

    public Long execute(DtoSaveUser dto){
        return this.serviceSaveUser.executeSave(User.of(dto.getIdentification(), dto.getName(),
                dto.getLastName(), dto.getEmail(), dto.getPassword(),
                dto.getRoles().stream().map(rol -> Rol.of(rol.getName(),
                        this.repositoryRolPostgresql.findDescriptionByName(rol.getName()))).toList()));
    }
}
