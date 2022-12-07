package com.uco.graduationproject.burstcar.infrastructure.service;

import com.uco.graduationproject.burstcar.domain.service.ServiceGeneratorToken;
import org.hibernate.cfg.Environment;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ServiceGenerateTokenJWT implements ServiceGeneratorToken {

    private final Environment environment;

    public ServiceGenerateTokenJWT(Environment environment) {
        this.environment = environment;
    }


    @Override
    public String execute(String user, List<String> roles) {
        return Jwts.builder()
                .setIssuer("BurstCar")
                .setSubject(user)
                .claim("roles", roles)
                .setIssuedAt(createDate(LocalDateTime.now()))
                .setExpiration(createDate(LocalDateTime.now().plusHours(1)))
                .setId(UUID.randomUUID().toString())
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode("=Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
                )
                .compact();

    }

    private static Date createDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
