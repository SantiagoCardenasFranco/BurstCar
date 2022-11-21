package com.uco.graduationproject.burstcar.domain.service.vehicleservice;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;

public class ServiceSaveVehicleService {

    private final RepositoryService repositoryService;

    public ServiceSaveVehicleService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }


    public Long executeSave(VehicleService vehicleService){
        if(!this.repositoryService.existService(vehicleService.getNameService())){
            return this.repositoryService.save(vehicleService);
        }
        throw new IllegalArgumentException("Este servicio ya se encuentra registrado, porfavor verificar");
    }
}
