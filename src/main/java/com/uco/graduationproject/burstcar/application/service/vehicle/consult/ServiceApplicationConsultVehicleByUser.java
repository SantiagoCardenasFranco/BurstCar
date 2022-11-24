package com.uco.graduationproject.burstcar.application.service.vehicle.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceConsultVehicleByUser;
import org.springframework.stereotype.Component;


@Component
public class ServiceApplicationConsultVehicleByUser {

    private final ServiceConsultVehicleByUser serviceConsultVehicleByUser;

    public ServiceApplicationConsultVehicleByUser(ServiceConsultVehicleByUser serviceConsultVehicleByUser) {
        this.serviceConsultVehicleByUser = serviceConsultVehicleByUser;
    }


    public DtoVehicleSummary execute(String userIdentification){
        return this.serviceConsultVehicleByUser.executeConsult(userIdentification);
    }
}
