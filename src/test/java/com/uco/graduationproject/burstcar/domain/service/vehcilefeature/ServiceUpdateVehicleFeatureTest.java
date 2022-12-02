package com.uco.graduationproject.burstcar.domain.service.vehcilefeature;

import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceSaveVehicleFeature;
import com.uco.graduationproject.burstcar.domain.service.vehiclefeature.ServiceUpdateVehicleFeature;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleFeatureTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceUpdateVehicleFeatureTest {

    @Test
    void updateUserSuccessful(){
        VehicleFeatures vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();

        VehicleFeatures vehicleFeaturesUpdate = new VehicleFeatureTestDataBuilder().byDefault()
                .withBrand("QSA-54S").withModel("2022").withBrand("Mazda").build();


        RepositoryVehicleFeature repositoryVehicleFeature = Mockito.mock(RepositoryVehicleFeature.class);
        when(repositoryVehicleFeature.existsFeature(Mockito.any())).thenReturn(false);
        when(repositoryVehicleFeature.saveFeature(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicleFeature serviceSaveVehicleFeature = new ServiceSaveVehicleFeature(repositoryVehicleFeature);
        Long id = serviceSaveVehicleFeature.executeSave(vehicleFeatures);

        RepositoryVehicleFeature repositoryVehicleFeatureUpdate = Mockito.mock(RepositoryVehicleFeature.class);
        when(repositoryVehicleFeatureUpdate.existsFeature(Mockito.any())).thenReturn(true);
        ServiceUpdateVehicleFeature serviceUpdateVehicleFeature = new ServiceUpdateVehicleFeature(repositoryVehicleFeatureUpdate);
        serviceUpdateVehicleFeature.executeUpdate(id, vehicleFeaturesUpdate);

        Mockito.verify(repositoryVehicleFeatureUpdate, Mockito.times(1)).updateFeature(
                id, vehicleFeaturesUpdate);
    }

    @Test
    void updateUserNoSuccessful(){
        VehicleFeatures vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();

        VehicleFeatures vehicleFeaturesUpdate = new VehicleFeatureTestDataBuilder().byDefault()
                .withBrand("QSA-54S").withModel("2022").withBrand("Mazda").build();


        RepositoryVehicleFeature repositoryVehicleFeature = Mockito.mock(RepositoryVehicleFeature.class);
        when(repositoryVehicleFeature.existsFeature(Mockito.any())).thenReturn(false);
        when(repositoryVehicleFeature.saveFeature(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicleFeature serviceSaveVehicleFeature = new ServiceSaveVehicleFeature(repositoryVehicleFeature);
        Long id = serviceSaveVehicleFeature.executeSave(vehicleFeatures);

        ServiceUpdateVehicleFeature serviceUpdateVehicleFeature = new ServiceUpdateVehicleFeature(repositoryVehicleFeature);

        Assertions.assertEquals("No existe ese vehiculo", Assertions.assertThrows(
                        IllegalArgumentException.class,
                        ()-> serviceUpdateVehicleFeature.executeUpdate(id, vehicleFeaturesUpdate))
                .getMessage());
    }
}
