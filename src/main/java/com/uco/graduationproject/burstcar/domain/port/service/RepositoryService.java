package com.uco.graduationproject.burstcar.domain.port.service;

import com.uco.graduationproject.burstcar.domain.model.Service;

import java.util.List;

public interface RepositoryService {
    List<Service> listService();
    Long save(Service service);
}
