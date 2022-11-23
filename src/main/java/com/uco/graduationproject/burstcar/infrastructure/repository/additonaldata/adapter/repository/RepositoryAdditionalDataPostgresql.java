package com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.adapter.repository;

import com.uco.graduationproject.burstcar.domain.dto.DtoAdditionalData;
import com.uco.graduationproject.burstcar.domain.port.additinaldata.RepositoryDataAdditional;
import com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.adapter.repository.jpa.RepositoryDataJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryAdditionalDataPostgresql implements RepositoryDataAdditional {

    private final RepositoryDataJpa repositoryDataJpa;

    public RepositoryAdditionalDataPostgresql(RepositoryDataJpa repositoryDataJpa) {
        this.repositoryDataJpa = repositoryDataJpa;
    }

    @Override
    public List<DtoAdditionalData> listFindAll() {
        return this.repositoryDataJpa.findAll().stream().map(
                entity -> new DtoAdditionalData(entity.getId(), entity.getQuantity(), entity.getTypeData())
        ).toList();
    }
}