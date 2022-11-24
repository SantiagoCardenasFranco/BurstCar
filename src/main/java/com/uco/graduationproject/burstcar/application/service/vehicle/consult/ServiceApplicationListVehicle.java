package com.uco.graduationproject.burstcar.application.service.vehicle.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationListVehicle {

    private final RepositoryVehicle repositoryVehicle;

    public ServiceApplicationListVehicle(RepositoryVehicle repositoryVehicle) {
        this.repositoryVehicle = repositoryVehicle;
    }


    public List<DtoVehicleSummary> execute(){
        return this.repositoryVehicle.listVehicle();
    }
}
