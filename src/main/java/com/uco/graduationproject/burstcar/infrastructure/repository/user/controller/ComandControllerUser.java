package com.uco.graduationproject.burstcar.infrastructure.repository.user.controller;

import com.uco.graduationproject.burstcar.application.user.comand.ServiceApplicationSaveUser;
import com.uco.graduationproject.burstcar.application.user.comand.ServiceApplicationUpdateUser;
import com.uco.graduationproject.burstcar.application.user.comand.dto.DtoSaveUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ComandControllerUser {

    private final ServiceApplicationSaveUser serviceApplicationSaveUser;
    private final ServiceApplicationUpdateUser serviceApplicationUpdateUser;

    public ComandControllerUser(ServiceApplicationSaveUser serviceApplicationSaveUser, ServiceApplicationUpdateUser serviceApplicationUpdateUser) {
        this.serviceApplicationSaveUser = serviceApplicationSaveUser;
        this.serviceApplicationUpdateUser = serviceApplicationUpdateUser;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Long saveUser(@RequestBody DtoSaveUser dtoSaveUser){
        return this.serviceApplicationSaveUser.execute(dtoSaveUser);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody DtoSaveUser dto){
        this.serviceApplicationUpdateUser.execute(id, dto);
    }
}
