package com.uco.graduationproject.burstcar.infrastructure.controller.login.comand;

import com.uco.graduationproject.burstcar.application.service.login.dto.DtoLogin;

public class ComandLoginTestDataBuilder {

    private String email;
    private String password;

    public ComandLoginTestDataBuilder byDefault() {
        this.email = "Nuevocorreo@gmailcom";
        this.password = "w5Lnpo<code>t0d0";
        return this;
    }

    public ComandLoginTestDataBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public ComandLoginTestDataBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public DtoLogin build(){
        return new DtoLogin(email, password);
    }
}
