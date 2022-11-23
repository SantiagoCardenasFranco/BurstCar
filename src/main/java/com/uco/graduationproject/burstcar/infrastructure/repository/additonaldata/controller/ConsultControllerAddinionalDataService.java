package com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.controller;

import com.uco.graduationproject.burstcar.application.service.additionaldata.consult.ServiceApplicationListAdditionalDataService;
import com.uco.graduationproject.burstcar.domain.dto.DtoAdditionalData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/additionalData")
public class ConsultControllerAddinionalDataService {

    private final ServiceApplicationListAdditionalDataService applicationListAdditionalDataService;

    public ConsultControllerAddinionalDataService(ServiceApplicationListAdditionalDataService applicationListAdditionalDataService) {
        this.applicationListAdditionalDataService = applicationListAdditionalDataService;
    }

    @GetMapping("/all")
    public List<DtoAdditionalData> listVehicleService(){
        return this.applicationListAdditionalDataService.execute();
    }
}
