package com.uco.graduationproject.burstcar.domain.service.vehicleservice;


import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleServiceTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceSaveVehicleServiceTest {

    @Test
    void createVehicleServiceSuccessful(){
        VehicleService vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();

        RepositoryService repositoryService = Mockito.mock(RepositoryService.class);
        when(repositoryService.existService(Mockito.any())).thenReturn(false);
        when(repositoryService.save(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicleService serviceSaveVehicleService = new ServiceSaveVehicleService(repositoryService);
        Long id = serviceSaveVehicleService.executeSave(vehicleService);

        Mockito.verify(repositoryService, Mockito.times(1)).existService(vehicleService.getNameService());
        Mockito.verify(repositoryService, Mockito.times(1)).save(vehicleService);
        Assertions.assertEquals(1L, id);
    }

    @Test
    void noCreateVehicleService(){
        VehicleService vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();

        RepositoryService repositoryService = Mockito.mock(RepositoryService.class);
        when(repositoryService.existService(Mockito.any())).thenReturn(true);
        when(repositoryService.save(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicleService serviceSaveVehicleService = new ServiceSaveVehicleService(repositoryService);

        Assertions.assertEquals("Este servicio ya se encuentra registrado, porfavor verificar",
                Assertions.assertThrows(
                                IllegalArgumentException.class, ()-> serviceSaveVehicleService.executeSave(vehicleService))
                .getMessage());
    }


}
