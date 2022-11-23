package com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.adapter.entity.EntityAdditionalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryDataJpa extends JpaRepository<EntityAdditionalData, Integer> {

}
