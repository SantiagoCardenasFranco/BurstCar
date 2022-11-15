package com.uco.graduationproject.burstcar.domain.port.vehiclefeatures;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import java.util.List;

public interface RepositoryVehicleFeature {
    List<VehicleFeatures> listFeature();
    Long saveFeature(VehicleFeatures vehicleFeatures);
    boolean existsFeature(VehicleFeatures vehicleFeatures);
    Boolean deleteFeature(Long id);
    Boolean updateFeature(Long id, VehicleFeatures vehicleFeatures);


}
