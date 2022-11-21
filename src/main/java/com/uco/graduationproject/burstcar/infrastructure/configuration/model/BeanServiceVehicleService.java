package com.uco.graduationproject.burstcar.infrastructure.configuration.model;

import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.service.vehicleservice.ServiceSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.service.vehicleservice.ServiceUpdateVehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceVehicleService {

    @Bean
    public ServiceSaveVehicleService serviceSaveVehicleService(RepositoryService repositoryService){
        return new ServiceSaveVehicleService(repositoryService);
    }

    @Bean ServiceUpdateVehicleService serviceUpdateVehicleService(RepositoryService repositoryService){
        return new ServiceUpdateVehicleService(repositoryService);
    }
}
