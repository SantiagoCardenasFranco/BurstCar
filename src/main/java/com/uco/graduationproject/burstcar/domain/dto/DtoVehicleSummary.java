package com.uco.graduationproject.burstcar.domain.dto;


import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoVehicleSummary {

    private VehicleFeatures vehicleFeatures;
    private VehicleService vehicleService;
    private DtoUserSummary user;
    private boolean isEnable;
}
