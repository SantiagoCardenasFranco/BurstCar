package com.uco.graduationproject.burstcar.infrastructure.user.adapter.repository;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.infrastructure.user.adapter.entity.EntityUser;
import com.uco.graduationproject.burstcar.infrastructure.user.adapter.repository.jpa.RepositoryUserJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUserPostgresql implements RepositoryUser {

    private final RepositoryUserJpa repositoryUserJpa;

    public RepositoryUserPostgresql(RepositoryUserJpa repositoryUserJpa) {
        this.repositoryUserJpa = repositoryUserJpa;
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
        return null;
    }

    @Override
    public boolean existUser(User user) {
        return false;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        return null;
    }

    @Override
    public User consultUser(String name, String password) {
        return null;
    }

    @Override
    public DtoUserSummary consultarPorId(Long id) {
        return null;
    }
}
