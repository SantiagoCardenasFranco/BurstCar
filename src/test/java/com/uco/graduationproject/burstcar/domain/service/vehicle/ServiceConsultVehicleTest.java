package com.uco.graduationproject.burstcar.domain.service.vehicle;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoUserSummaryTestDataBuilder;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoVehicleSummaryTestDataBuilder;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceConsultVehicleTest {

    @Test
    void consultVehicleByIdentificationUserSuccessful(){
        Vehicle vehicle = new VehicleTestDataBuilder().byDefault().build();
        DtoUserSummary dtoUserSummary = new DtoUserSummaryTestDataBuilder().byDefault().build();
        DtoVehicleSummary dto = new DtoVehicleSummaryTestDataBuilder().byDefault()
                .withVehicleFeatures(vehicle.getVehicleFeatures())
                .withVehicleService(vehicle.getVehicleService())
                .withUser(dtoUserSummary).withEnable(vehicle.isEnable()).build();

        //Create
        RepositoryVehicle repositoryVehicle = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicle.saveVehicle(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicle serviceSaveVehicle = new ServiceSaveVehicle(repositoryVehicle);
        serviceSaveVehicle.executeSave(vehicle);

        //Consult
        RepositoryVehicle repositoryVehicleConsult = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicleConsult.consultByUser(Mockito.any())).thenReturn(dto);
        ServiceConsultVehicleByUser serviceConsultVehicleByUser = new ServiceConsultVehicleByUser(repositoryVehicleConsult);
        DtoVehicleSummary vehicleFind = serviceConsultVehicleByUser.executeConsult(vehicle.getUser().getIdentification());

        Assertions.assertEquals(vehicleFind.getVehicleService(), dto.getVehicleService());
        Assertions.assertEquals(vehicleFind.getVehicleFeatures(), dto.getVehicleFeatures());
        Assertions.assertEquals(vehicleFind.isEnable(), dto.isEnable());
        Assertions.assertEquals(vehicleFind.getUser().getIdentification(), dto.getUser().getIdentification());
        Assertions.assertEquals(vehicleFind.getUser().getName(), dto.getUser().getName());
        Assertions.assertEquals(vehicleFind.getUser().getLastName(), dto.getUser().getLastName());
        Assertions.assertEquals(vehicleFind.getUser().getEmail(), dto.getUser().getEmail());
        Assertions.assertEquals(vehicleFind.getUser().getRols().get(0).getName(), dto.getUser().getRols().get(0).getName());
        Assertions.assertEquals(vehicleFind.getUser().getRols().get(0).getDescription(), dto.getUser().getRols().get(0)
                .getDescription());
    }

    @Test
    void noConsultVehicleByIdentificationUser(){
        Vehicle vehicle = new VehicleTestDataBuilder().byDefault().build();
        DtoUserSummary dtoUserSummary = new DtoUserSummaryTestDataBuilder().byDefault().build();
        DtoVehicleSummary dto = new DtoVehicleSummaryTestDataBuilder().byDefault()
                .withVehicleFeatures(vehicle.getVehicleFeatures())
                .withVehicleService(vehicle.getVehicleService())
                .withUser(dtoUserSummary).withEnable(vehicle.isEnable()).build();

        //Create
        RepositoryVehicle repositoryVehicle = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicle.saveVehicle(Mockito.any())).thenReturn(1L);
        ServiceSaveVehicle serviceSaveVehicle = new ServiceSaveVehicle(repositoryVehicle);
        serviceSaveVehicle.executeSave(vehicle);

        //Find
        RepositoryVehicle repositoryVehicleConsult = Mockito.mock(RepositoryVehicle.class);
        when(repositoryVehicleConsult.consultByUser(Mockito.any())).thenReturn(null);
        ServiceConsultVehicleByUser serviceConsultVehicleByUser = new ServiceConsultVehicleByUser(repositoryVehicleConsult);


        Assertions.assertEquals("No hay un usuario asociado al vehiculo", Assertions.assertThrows(
                        IllegalArgumentException.class,
                        ()-> serviceConsultVehicleByUser.executeConsult(dto.getUser().getIdentification())).getMessage());
    }
}
