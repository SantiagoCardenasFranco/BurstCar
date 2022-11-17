package com.uco.graduationproject.burstcar.application.mapper;

public interface MapperObjectApplication<Dto, D>{

    D mapperUserToDomain(Dto dto);
    Dto mapperUserToDto(D domain);
}
