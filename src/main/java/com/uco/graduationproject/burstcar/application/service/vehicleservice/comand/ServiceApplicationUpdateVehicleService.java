package com.uco.graduationproject.burstcar.application.service.vehicleservice.comand;

import com.uco.graduationproject.burstcar.application.mapper.vehicleservice.impl.MapperVehicleServiceApplicationImpl;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.service.vehicleservice.ServiceUpdateVehicleService;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationUpdateVehicleService {

    private final ServiceUpdateVehicleService serviceUpdateVehicleService;
    private final MapperVehicleServiceApplicationImpl mapperVehicleServiceApplication;

    public ServiceApplicationUpdateVehicleService(ServiceUpdateVehicleService serviceUpdateVehicleService, MapperVehicleServiceApplicationImpl mapperVehicleServiceApplication) {
        this.serviceUpdateVehicleService = serviceUpdateVehicleService;
        this.mapperVehicleServiceApplication = mapperVehicleServiceApplication;
    }


    public boolean execute(Long id, DtoSaveVehicleService dto){
        return this.serviceUpdateVehicleService.executeUpdate(id,
                this.mapperVehicleServiceApplication.mapperUserToDomain(dto));
    }

}
