package com.uco.graduationproject.burstcar.infrastructure.rol.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.entity.EntityRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRolJpa extends JpaRepository<EntityRol, Long> {

    @Query(value = "Select description from rol_user Where rol_user.name = name", nativeQuery = true)
    String findRol(String name);

}
