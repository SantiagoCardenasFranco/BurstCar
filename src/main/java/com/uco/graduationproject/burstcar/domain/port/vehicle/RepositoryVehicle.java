package com.uco.graduationproject.burstcar.domain.port.vehicle;

import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import java.util.List;

public interface RepositoryVehicle {
    List<DtoVehicleSummary> listVehicle();
    Long saveVehicle(Vehicle vehicle);
    DtoVehicleSummary consultByUser(String userIdentification);
    List<DtoVehicleSummary> consultByServiceAndEnabled(boolean bool, String nameService);
}
