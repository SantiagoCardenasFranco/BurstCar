package com.uco.graduationproject.burstcar.domain.port.vehiclefeatures;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;

public interface RepositoryVehicleFeature {
    Long saveFeature(VehicleFeatures vehicleFeatures);
    boolean existsFeature(VehicleFeatures vehicleFeatures);
    Boolean updateFeature(Long id, VehicleFeatures vehicleFeatures);
    VehicleFeatures findFeatures(String licensePlate);


}
