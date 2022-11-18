package com.uco.graduationproject.burstcar.infrastructure.configuration.model;

import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceFindUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceSaveUser;
import com.uco.graduationproject.burstcar.domain.service.user.ServiceUpdateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser {

    @Bean
    public ServiceSaveUser serviceSaveUser(RepositoryUser repositoryUser){
        return new ServiceSaveUser(repositoryUser);
    }

    @Bean
    public ServiceUpdateUser serviceUpdateUser(RepositoryUser repositoryUser){
        return new ServiceUpdateUser(repositoryUser);
    }

    @Bean
    public ServiceFindUser serviceFindUser(RepositoryUser repositoryUser){
        return new ServiceFindUser(repositoryUser);
    }
}
