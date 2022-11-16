package com.uco.graduationproject.burstcar.infrastructure.user.adapter.repository;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.entity.EntityRol;
import com.uco.graduationproject.burstcar.infrastructure.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.user.adapter.repository.jpa.RepositoryUserJpa;
import com.uco.graduationproject.burstcar.infrastructure.user.mapper.user.impl.EntityToDomainImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUserPostgresql implements RepositoryUser {

    private final RepositoryUserJpa repositoryUserJpa;
    private final EntityToDomainImpl entityToDomain;

    public RepositoryUserPostgresql(RepositoryUserJpa repositoryUserJpa, EntityToDomainImpl entityToDomain) {
        this.repositoryUserJpa = repositoryUserJpa;
        this.entityToDomain = entityToDomain;
    }

    @Override
    public List<DtoUserSummary> listUser() {
        List<EntityUser> entityUsers = this.repositoryUserJpa.findAll();

        return entityUsers.stream().map(entity -> new DtoUserSummary(entity.getIdentification(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getRoles().stream().map(roles -> Rol.of(roles.getName(),
                        roles.getDescription())).toList())).toList();
    }

    @Override
    public Long saveUser(User user) {
        return this.repositoryUserJpa.save(this.entityToDomain.mapperUserEntity(user)).getId();
    }

    @Override
    public boolean existUser(User user) {
        return false;
    }

    @Override
    public Boolean deleteUser(Long id) {
        this.repositoryUserJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        EntityUser entityUser = new EntityUser();
        entityUser.setId(id);
        entityUser.setIdentification(user.getIdentification());
        entityUser.setName(user.getName());
        entityUser.setLastName(user.getEmail());
        entityUser.setPassword(user.getPassword());
        entityUser.setRoles(user.getRols().stream().map(rol -> new EntityRol(rol.getName(),
                rol.getName())).toList());
        return true;
    }

    @Override
    public User consultUser(String email, String password) {
        return null;
    }

    @Override
    public DtoUserSummary consultById(Long id) {
        return this.repositoryUserJpa.
                findById(id).
                map(entityUser -> new DtoUserSummary(entityUser.getIdentification(),
                        entityUser.getName(), entityUser.getLastName(), entityUser.getEmail(),
                        entityUser.getRoles().stream().map(rol -> Rol.of(rol.getName(),
                                rol.getDescription())).toList()))
                .orElse(null);
    }

    @Override
    public User consultByIdentification(String identification) {
        EntityUser entityUser = this.repositoryUserJpa.findByIdentification(identification);
        return this.entityToDomain.mapperUserDomain(entityUser);
    }
}
