package com.uco.graduationproject.burstcar.domain.service.vehcilefeature;


import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleFeatureTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceSaveVehicleFeatureTest {

    @Test
    void createVehicleFeatureSuccessful(){
        VehicleFeatures vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();

        RepositoryVehicleFeature repositoryVehicleFeature = Mockito.mock(RepositoryVehicleFeature.class);
        when(repositoryVehicleFeature.existsFeature(Mockito.any())).thenReturn(false);
        when(repositoryVehicleFeature.saveFeature(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicleFeature serviceSaveVehicleFeature = new ServiceSaveVehicleFeature(repositoryVehicleFeature);
        Long id = serviceSaveVehicleFeature.executeSave(vehicleFeatures);

        Mockito.verify(repositoryVehicleFeature, Mockito.times(1)).existsFeature(vehicleFeatures);
        Mockito.verify(repositoryVehicleFeature, Mockito.times(1)).saveFeature(vehicleFeatures);
        Assertions.assertEquals(1L, id);
    }

    @Test
    void noCreateVehicleService(){
        VehicleFeatures vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();

        RepositoryVehicleFeature repositoryVehicleFeature = Mockito.mock(RepositoryVehicleFeature.class);
        when(repositoryVehicleFeature.existsFeature(Mockito.any())).thenReturn(true);
        when(repositoryVehicleFeature.saveFeature(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicleFeature serviceSaveVehicleFeature = new ServiceSaveVehicleFeature(repositoryVehicleFeature);

        Assertions.assertEquals("Estas castacteristicas de su vehiculo es muy parecida a una que ya está " +
                        "registrada, por favor ingrese de nuevo los datos",
                Assertions.assertThrows(
                                IllegalArgumentException.class, ()-> serviceSaveVehicleFeature.executeSave(vehicleFeatures))
                .getMessage());
    }


}
