package com.uco.graduationproject.burstcar.domain.service.vehicle;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;

public class ServiceConsultVehicleByUser {

    private final RepositoryVehicle repositoryVehicle;

    public ServiceConsultVehicleByUser(RepositoryVehicle repositoryVehicle) {
        this.repositoryVehicle = repositoryVehicle;
    }

    public DtoVehicleSummary executeConsult(String userIdentification){
        DtoVehicleSummary vehicle = this.repositoryVehicle.consultByUser(userIdentification);
        if(vehicle != null){
            return vehicle;
        }
        throw new IllegalArgumentException("No hay un usuario asociado al vehiculo");
    }
}
