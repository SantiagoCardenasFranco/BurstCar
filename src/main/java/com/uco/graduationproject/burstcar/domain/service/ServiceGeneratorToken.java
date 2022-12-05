package com.uco.graduationproject.burstcar.domain.service;


import java.util.List;

public interface ServiceGeneratorToken {

    String execute(String user, List<String> roles);
}
