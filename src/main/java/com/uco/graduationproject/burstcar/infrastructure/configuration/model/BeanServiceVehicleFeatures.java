package com.uco.graduationproject.burstcar.infrastructure.configuration.model;

import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceUpdateVehicleFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceVehicleFeatures {

    @Bean
    public ServiceSaveVehicleFeature serviceSaveVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature){
        return new ServiceSaveVehicleFeature(repositoryVehicleFeature);
    }

    @Bean
    public ServiceUpdateVehicleFeature serviceUpdateVehicleFeature(RepositoryVehicleFeature repositoryVehicleFeature){
        return new ServiceUpdateVehicleFeature(repositoryVehicleFeature);
    }
}
