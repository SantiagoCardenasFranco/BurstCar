package com.uco.graduationproject.burstcar.application.service.vehicle.consult;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.service.vehicle.ServiceConsultVehicleByServiceAndEnabled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApplicationConsultVehicleByServiceAndEnabled {

    private final ServiceConsultVehicleByServiceAndEnabled serviceConsultVehicleByServiceAndEnabled;

    public ServiceApplicationConsultVehicleByServiceAndEnabled(ServiceConsultVehicleByServiceAndEnabled serviceConsultVehicleByServiceAndEnabled) {
        this.serviceConsultVehicleByServiceAndEnabled = serviceConsultVehicleByServiceAndEnabled;
    }

    public List<DtoVehicleSummary> execute(boolean bool, String nameService){
        return this.serviceConsultVehicleByServiceAndEnabled.executeSearch(bool, nameService);
    }
}
