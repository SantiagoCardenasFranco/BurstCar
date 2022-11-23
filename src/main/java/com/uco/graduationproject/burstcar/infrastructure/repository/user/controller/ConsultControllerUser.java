package com.uco.graduationproject.burstcar.infrastructure.repository.user.controller;

import com.uco.graduationproject.burstcar.application.service.user.consult.ServiceApplicationFindUser;
import com.uco.graduationproject.burstcar.application.service.user.consult.ServiceApplicationListUser;
import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ConsultControllerUser {

    private final ServiceApplicationListUser serviceApplicationListUser;
    private final ServiceApplicationFindUser serviceApplicationFindUser;

    public ConsultControllerUser(ServiceApplicationListUser serviceApplicationListUser, ServiceApplicationFindUser serviceApplicationFindUser) {
        this.serviceApplicationListUser = serviceApplicationListUser;
        this.serviceApplicationFindUser = serviceApplicationFindUser;
    }

    @GetMapping("/all")
    public List<DtoUserSummary> list(){
        return this.serviceApplicationListUser.execute();
    }

    @GetMapping("/find")
    //Ejemplo de como queda la ruta http://localhost:8888/user/find?identification="Valor"
    //Este @RequestParam, se utiliza cuando se tiene que enviar varios datos desde la url
    public DtoUserSummary findOne(@RequestParam("identification") String identification){
        return this.serviceApplicationFindUser.execute(identification);
    }
}
