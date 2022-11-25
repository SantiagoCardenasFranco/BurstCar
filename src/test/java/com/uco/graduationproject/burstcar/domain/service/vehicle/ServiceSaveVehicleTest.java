package com.uco.graduationproject.burstcar.domain.service.vehicle;


import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceSaveVehicleTest {

    @Test
    void createVehicleSuccessful(){
        Vehicle vehicle = new VehicleTestDataBuilder().byDefault().build();

        RepositoryVehicle repositoryVehicle = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicle.saveVehicle(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicle serviceSaveVehicle = new ServiceSaveVehicle(repositoryVehicle);
        Long id = serviceSaveVehicle.executeSave(vehicle);

        Mockito.verify(repositoryVehicle, Mockito.times(1)).saveVehicle(vehicle);
        Assertions.assertEquals(1L, id);
    }

/*    @Test
    void noCreateVehicle(){
        Vehicle vehicle = new VehicleTestDataBuilder().byDefault().build();

        RepositoryVehicle repositoryVehicle = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicle.saveVehicle(Mockito.any())).thenReturn(1L);

        ServiceSaveVehicle serviceSaveVehicle = new ServiceSaveVehicle(repositoryVehicle);

        Assertions.assertEquals("Ya existe un usuario, favor de ingresar uno nuevo",
                Assertions.assertThrows(
                                IllegalArgumentException.class, ()-> serviceSaveVehicle.executeSave(vehicle))
                .getMessage());
    }
*/
}
