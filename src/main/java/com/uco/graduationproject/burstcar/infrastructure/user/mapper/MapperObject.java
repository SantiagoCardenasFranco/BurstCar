package com.uco.graduationproject.burstcar.infrastructure.user.mapper;

public interface MapperObject<E, D> {

    D mapperUserDomain(E entity);
    E mapperUserEntity(D domain);
}
