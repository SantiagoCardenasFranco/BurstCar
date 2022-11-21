package com.uco.graduationproject.burstcar.domain.service.vehicleservice;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;

public class ServiceUpdateVehicleService {

    private final RepositoryService repositoryService;

    public ServiceUpdateVehicleService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public boolean executeUpdate(Long id, VehicleService vehicleService){
        validatorExist(vehicleService);
        return this.repositoryService.updateService(id, vehicleService);
    }

    private void validatorExist(VehicleService service){
        if(!this.repositoryService.existService(service.getNameService())){
            throw new IllegalArgumentException("No existe ese servicio");
        }
    }
}
