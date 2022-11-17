package com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.repository.jpa;

import com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUserJpa extends JpaRepository<EntityUser, Long> {
    EntityUser findByIdentification(String identification);
}
