package com.uco.graduationproject.burstcar.application.service.vehicle.comand;


import com.uco.graduationproject.burstcar.application.mapper.vehicle.impl.MapperVehicleApplicationImpl;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicle;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceSaveVehicle;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveVehicle {

    private final ServiceSaveVehicle serviceSaveVehicle;
    private final MapperVehicleApplicationImpl mapperVehicleApplication;

    public ServiceApplicationSaveVehicle(ServiceSaveVehicle serviceSaveVehicle, MapperVehicleApplicationImpl mapperVehicleApplication) {
        this.serviceSaveVehicle = serviceSaveVehicle;
        this.mapperVehicleApplication = mapperVehicleApplication;
    }


    public Long execute(DtoSaveVehicle dto){
        return this.serviceSaveVehicle.executeSave(this.mapperVehicleApplication.mapperUserToDomain(dto));
    }
}
