package com.uco.graduationproject.burstcar.domain.service.vehicle;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;

import java.util.List;

public class ServiceConsultVehicleByServiceAndEnabled {

    private final RepositoryVehicle repositoryVehicle;

    public ServiceConsultVehicleByServiceAndEnabled(RepositoryVehicle repositoryVehicle) {
        this.repositoryVehicle = repositoryVehicle;
    }

    public List<DtoVehicleSummary> executeSearch(boolean bool, String nameService){
        List<DtoVehicleSummary> dto = this.repositoryVehicle.consultByServiceAndEnabled(bool, nameService);
        if(!dto.isEmpty()){
            return dto;
        }
        throw new IllegalArgumentException("No se encontró ningun vehiculo disponible con " +
                "el servicio solicitado");

    }
}
