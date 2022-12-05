package com.uco.graduationproject.burstcar.application.service.login;

import com.uco.graduationproject.burstcar.application.encrypted.ServiceEncryptedPassword;
import com.uco.graduationproject.burstcar.application.service.login.dto.DtoLogin;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.domain.service.ServiceGeneratorToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationLogin {

    private final ServiceEncryptedPassword serviceEncryptedPassword;
    //private final ServiceGeneratorToken serviceGeneratorToken;
    private final RepositoryUser repositoryUser;

    public ServiceApplicationLogin(ServiceEncryptedPassword serviceEncryptedPassword , RepositoryUser repositoryUser) {
        this.serviceEncryptedPassword = serviceEncryptedPassword;
        //this.serviceGeneratorToken = serviceGeneratorToken;
        this.repositoryUser = repositoryUser;
    }


    public String execute(DtoLogin dto){
        String passwordEncrypted = this.serviceEncryptedPassword.execute(dto.getPassword());
        User user = this.repositoryUser.consultUser(dto.getEmail(), passwordEncrypted);
        if(user == null){
            throw  new IllegalStateException("Email o contraseña incorrecta");
        }

        //List<String> roles = user.getRols().stream().map(Rol::getRol).toList();
        //Falta implementar token
        //return this.serviceGeneratorToken.execute(dto.getEmail(), roles)
        return "Hecho";
    }
}
