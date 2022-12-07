package com.uco.graduationproject.burstcar.infrastructure.service;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserCurrent;
import com.uco.graduationproject.burstcar.domain.service.ServiceGetUser;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class ServiceObtainrUserCurrentJwt implements ServiceGetUser {
    @Override
    public DtoUserCurrent execute() {
        DecodedJWT decoded = JWT.decode(obtainTokenActual());
        return new DtoUserCurrent(decoded.getSubject(), decoded.getClaim("roles").asList(String.class));
    }

    private String obtainTokenActual() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }
}
