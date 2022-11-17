package com.uco.graduationproject.burstcar.infrastructure.repository.user.controller;

import com.uco.graduationproject.burstcar.application.user.consult.ServiceApplicationListUser;
import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ConsultControllerUser {

    private final ServiceApplicationListUser serviceApplicationListUser;

    public ConsultControllerUser(ServiceApplicationListUser serviceApplicationListUser) {
        this.serviceApplicationListUser = serviceApplicationListUser;
    }

    @GetMapping("/all")
    public List<DtoUserSummary> list(){
        return this.serviceApplicationListUser.execute();
    }
}
