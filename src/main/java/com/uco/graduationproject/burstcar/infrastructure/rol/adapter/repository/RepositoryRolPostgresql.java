package com.uco.graduationproject.burstcar.infrastructure.rol.adapter.repository;

import com.uco.graduationproject.burstcar.domain.port.rol.RepositoryRol;
import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.repository.jpa.RepositoryRolJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryRolPostgresql implements RepositoryRol {

    private final RepositoryRolJpa repositoryRolJpa;

    public RepositoryRolPostgresql(RepositoryRolJpa repositoryRolJpa) {
        this.repositoryRolJpa = repositoryRolJpa;
    }

    @Override
    public String findDescriptionByName(String nameRol) {
        return this.repositoryRolJpa.findRol(nameRol);
    }
}
