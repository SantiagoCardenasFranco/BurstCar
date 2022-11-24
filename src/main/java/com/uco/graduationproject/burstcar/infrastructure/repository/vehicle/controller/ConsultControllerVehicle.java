package com.uco.graduationproject.burstcar.infrastructure.repository.vehicle.controller;

import com.uco.graduationproject.burstcar.application.service.vehicle.consult.ServiceApplicationConsultVehicleByServiceAndEnabled;
import com.uco.graduationproject.burstcar.application.service.vehicle.consult.ServiceApplicationConsultVehicleByUser;
import com.uco.graduationproject.burstcar.application.service.vehicle.consult.ServiceApplicationListVehicle;
import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class ConsultControllerVehicle {

    private final ServiceApplicationListVehicle serviceApplicationListVehicle;
    private final ServiceApplicationConsultVehicleByUser serviceApplicationConsultVehicleByUser;
    private final ServiceApplicationConsultVehicleByServiceAndEnabled serviceApplicationConsultVehicleByServiceAndEnabled;

    public ConsultControllerVehicle(ServiceApplicationListVehicle serviceApplicationListVehicle, ServiceApplicationConsultVehicleByUser serviceApplicationConsultVehicleByUser, ServiceApplicationConsultVehicleByServiceAndEnabled serviceApplicationConsultVehicleByServiceAndEnabled) {
        this.serviceApplicationListVehicle = serviceApplicationListVehicle;
        this.serviceApplicationConsultVehicleByUser = serviceApplicationConsultVehicleByUser;
        this.serviceApplicationConsultVehicleByServiceAndEnabled = serviceApplicationConsultVehicleByServiceAndEnabled;
    }

    @GetMapping("/all")
    public List<DtoVehicleSummary> listVehicle(){
        return this.serviceApplicationListVehicle.execute();
    }

    @GetMapping("/user/{identification}")
    public DtoVehicleSummary consultVehicleByUser(@PathVariable("identification") String identification){
        return this.serviceApplicationConsultVehicleByUser.execute(identification);
    }

    @GetMapping("/enabled")
    //http://localhost:8888/vehicle/enabled?isEnabled=false&nameService=Carga
    public List<DtoVehicleSummary> consultVehicleByUser(@RequestParam("isEnabled") boolean bool,
                                                  @RequestParam("nameService") String name){
        return this.serviceApplicationConsultVehicleByServiceAndEnabled.execute(bool, name);
    }


}
