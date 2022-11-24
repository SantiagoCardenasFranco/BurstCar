package com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto;


import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoSaveVehicle {

    private VehicleFeatures vehicleFeatures;
    private DtoSaveVehicleService dtoSaveVehicleService;
    private User user;
}
