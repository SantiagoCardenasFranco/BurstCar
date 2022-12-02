package com.uco.graduationproject.burstcar.domain.service.vehicleservice;


import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleServiceTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ServiceUpdateVehicleServiceTest {

    @Test
    void updateUserSuccessful(){
        VehicleService vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();
        VehicleService vehicleServiceUpdate = new VehicleServiceTestDataBuilder().byDefault()
                .withName("Transporte")
                .withDescription("Llevar a un cliente").build();

        RepositoryService repositoryService = Mockito.mock(RepositoryService.class);
        when(repositoryService.existService(Mockito.any())).thenReturn(false);
        when(repositoryService.save(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicleService serviceSaveVehicleService = new ServiceSaveVehicleService(repositoryService);
        Long id = serviceSaveVehicleService.executeSave(vehicleService);

        RepositoryService repositoryServiceUpdate = Mockito.mock(RepositoryService.class);
        when(repositoryServiceUpdate.existService(Mockito.any())).thenReturn(true);
        ServiceUpdateVehicleService serviceUpdateVehicleService = new ServiceUpdateVehicleService(repositoryServiceUpdate);
        serviceUpdateVehicleService.executeUpdate(id, vehicleServiceUpdate);

        Mockito.verify(repositoryServiceUpdate, Mockito.times(1)).updateService(
                id, vehicleServiceUpdate);
    }

    @Test
    void updateUserNoSuccessful(){
        VehicleService vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();
        VehicleService vehicleServiceUpdate = new VehicleServiceTestDataBuilder().byDefault()
                .withName("Transporte")
                .withDescription("Llevar a un cliente").build();

        RepositoryService repositoryService = Mockito.mock(RepositoryService.class);
        when(repositoryService.existService(Mockito.any())).thenReturn(false);
        when(repositoryService.save(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicleService serviceSaveVehicleService = new ServiceSaveVehicleService(repositoryService);
        Long id = serviceSaveVehicleService.executeSave(vehicleService);

        ServiceUpdateVehicleService serviceUpdateVehicleService = new ServiceUpdateVehicleService(repositoryService);

        Assertions.assertEquals("No existe ese servicio", Assertions.assertThrows(
                        IllegalArgumentException.class,
                        ()-> serviceUpdateVehicleService.executeUpdate(id, vehicleServiceUpdate))
                .getMessage());
    }
}
