package com.uco.graduationproject.burstcar.application.vehicleservice.consult;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationListVehicleService {

    private final RepositoryService repositoryService;

    public ServiceApplicationListVehicleService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }


    public List<VehicleService> execute(){
        return this.repositoryService.listService();
    }
}
