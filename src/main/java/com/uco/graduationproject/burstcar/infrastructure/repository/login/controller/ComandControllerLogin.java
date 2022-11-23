package com.uco.graduationproject.burstcar.infrastructure.repository.login.controller;

import com.uco.graduationproject.burstcar.application.service.login.ServiceApplicationLogin;
import com.uco.graduationproject.burstcar.application.service.login.dto.DtoLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ComandControllerLogin {

    private final ServiceApplicationLogin serviceApplicationLogin;

    public ComandControllerLogin(ServiceApplicationLogin serviceApplicationLogin) {
        this.serviceApplicationLogin = serviceApplicationLogin;
    }

    @PostMapping
    public String login(@RequestBody DtoLogin dto) {
        return this.serviceApplicationLogin.execute(dto);
    }
}
