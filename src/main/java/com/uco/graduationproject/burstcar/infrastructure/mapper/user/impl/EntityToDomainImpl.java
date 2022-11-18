package com.uco.graduationproject.burstcar.infrastructure.mapper.user.impl;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.infrastructure.repository.rol.adapter.entity.EntityRol;
import com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.mapper.MapperInfrastructureObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityToDomainImpl implements MapperInfrastructureObject<EntityUser, User> {
    @Override
    public User mapperUserToDomain(EntityUser entity) {
        return User.of(entity.getIdentification(), entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(),
                entity.getRoles().stream().map(rol -> Rol.of(rol.getName(), rol.getDescription())).toList());
    }

    @Override
    public EntityUser mapperUserToEntity(User domain) {
        return new EntityUser(domain.getIdentification(), domain.getName(), domain.getLastName(),
                domain.getEmail(), domain.getPassword(),
                domain.getRols().stream().map(rolEntity -> new EntityRol(rolEntity.getName(),
                        rolEntity.getDescription())).toList());
    }

    public DtoUserSummary mapperUserToDtoSummary(EntityUser entityUser){
        return new DtoUserSummary(entityUser.getIdentification(), entityUser.getName(),
                entityUser.getLastName(), entityUser.getEmail(), entityUser.getRoles().stream().map(
                        rol -> Rol.of(rol.getName(), rol.getDescription())).toList());
    }
}
