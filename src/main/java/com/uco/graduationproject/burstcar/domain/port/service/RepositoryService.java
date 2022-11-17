package com.uco.graduationproject.burstcar.domain.port.service;

import com.uco.graduationproject.burstcar.domain.model.VehicleService;

import java.util.List;

public interface RepositoryService {
    List<VehicleService> listService();
    Long save(VehicleService service);
}
