package com.uco.graduationproject.burstcar.infrastructure.user.mapper.user.impl;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.entity.EntityRol;
import com.uco.graduationproject.burstcar.infrastructure.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.user.mapper.MapperObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityToDomainImpl implements MapperObject<EntityUser, User> {
    @Override
    public User mapperUserDomain(EntityUser entity) {
        return User.of(entity.getIdentification(), entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(),
                entity.getRoles().stream().map(rol -> Rol.of(rol.getName(), rol.getDescription())).toList());
    }

    @Override
    public EntityUser mapperUserEntity(User domain) {
        return new EntityUser(domain.getIdentification(), domain.getName(), domain.getLastName(),
                domain.getEmail(), domain.getPassword(),
                domain.getRols().stream().map(rolEntity -> new EntityRol(rolEntity.getName(),
                        rolEntity.getDescription())).toList());
    }
}
