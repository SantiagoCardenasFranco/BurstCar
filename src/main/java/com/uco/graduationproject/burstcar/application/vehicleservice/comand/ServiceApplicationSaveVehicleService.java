package com.uco.graduationproject.burstcar.application.vehicleservice.comand;

import com.uco.graduationproject.burstcar.application.mapper.vehicleservice.impl.MapperVehicleServiceApplicationImpl;
import com.uco.graduationproject.burstcar.application.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.service.vehicleservice.ServiceSaveVehicleService;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveVehicleService {

    private final ServiceSaveVehicleService serviceSaveVehicleService;
    private final MapperVehicleServiceApplicationImpl mapperVehicleServiceApplication;

    public ServiceApplicationSaveVehicleService(ServiceSaveVehicleService serviceSaveVehicleService, MapperVehicleServiceApplicationImpl mapperVehicleServiceApplication) {
        this.serviceSaveVehicleService = serviceSaveVehicleService;
        this.mapperVehicleServiceApplication = mapperVehicleServiceApplication;
    }


    public Long execute(DtoSaveVehicleService dto){
        return this.serviceSaveVehicleService.executeSave(
                this.mapperVehicleServiceApplication.mapperUserToDomain(dto));
    }

}
