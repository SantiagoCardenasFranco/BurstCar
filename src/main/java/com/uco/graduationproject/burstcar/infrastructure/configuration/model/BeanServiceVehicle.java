package com.uco.graduationproject.burstcar.infrastructure.configuration.model;

import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceConsultVehicleByServiceAndEnabled;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceConsultVehicleByUser;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceSaveVehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceVehicle {

    @Bean
    public ServiceSaveVehicle serviceSaveVehicle(RepositoryVehicle repositoryVehicle){
        return new ServiceSaveVehicle(repositoryVehicle);
    }

    @Bean
    public ServiceConsultVehicleByUser serviceConsultUserVehicle(RepositoryVehicle repositoryVehicle){
        return new ServiceConsultVehicleByUser(repositoryVehicle);
    }

    @Bean
    public ServiceConsultVehicleByServiceAndEnabled serviceConsultVehicleByServiceAndEnabled(RepositoryVehicle repositoryVehicle){
        return new ServiceConsultVehicleByServiceAndEnabled(repositoryVehicle);
    }
}
