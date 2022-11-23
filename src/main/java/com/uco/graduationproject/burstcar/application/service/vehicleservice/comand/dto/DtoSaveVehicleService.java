package com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoSaveVehicleService {
    private String nameService;
    private String descriptionService;
}
