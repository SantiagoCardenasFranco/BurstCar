package com.uco.graduationproject.burstcar.infrastructure.user.controller;

import com.uco.graduationproject.burstcar.application.user.comand.ServiceApplicationSaveUser;
import com.uco.graduationproject.burstcar.application.user.comand.dto.DtoSaveUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ComandControllerUser {

    private final ServiceApplicationSaveUser serviceApplicationSaveUser;

    public ComandControllerUser(ServiceApplicationSaveUser serviceApplicationSaveUser) {
        this.serviceApplicationSaveUser = serviceApplicationSaveUser;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveUser(@RequestBody DtoSaveUser dtoSaveUser){
        return this.serviceApplicationSaveUser.execute(dtoSaveUser);
    }
}
