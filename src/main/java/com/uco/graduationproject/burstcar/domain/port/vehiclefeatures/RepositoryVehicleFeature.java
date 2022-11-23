package com.uco.graduationproject.burstcar.domain.port.vehiclefeatures;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;

import java.util.List;

public interface RepositoryVehicleFeature {
    Long saveFeature(VehicleFeatures vehicleFeatures);
    boolean existsFeature(VehicleFeatures vehicleFeatures);
    void updateFeature(Long id, VehicleFeatures vehicleFeatures);
    VehicleFeatures findFeatures(String licensePlate);
    List<VehicleFeatures> listFeatures();
}
