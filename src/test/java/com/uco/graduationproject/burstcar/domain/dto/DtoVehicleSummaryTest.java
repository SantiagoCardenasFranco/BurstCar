package com.uco.graduationproject.burstcar.domain.dto;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoVehicleSummaryTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DtoVehicleSummaryTest {

    @Test
    void validateCreationSuccessful() {
        DtoVehicleSummary vehicle = new DtoVehicleSummaryTestDataBuilder().byDefault().build();

        Assertions.assertEquals("XAS-42A", vehicle.getVehicleFeatures().getLicensePlate());
        Assertions.assertEquals("2023", vehicle.getVehicleFeatures().getModel());
        Assertions.assertEquals("Chevrolet", vehicle.getVehicleFeatures().getBrand());
        Assertions.assertEquals("Carga", vehicle.getVehicleService().getNameService());
        Assertions.assertEquals("Encargado de llevar las cosas seguras de un lugar a otro",
                vehicle.getVehicleService().getDescriptionService());
        Assertions.assertEquals("1234567890", vehicle.getUser().getIdentification());
        Assertions.assertEquals("Nombre", vehicle.getUser().getName());
        Assertions.assertEquals("Apellido", vehicle.getUser().getLastName());
        Assertions.assertEquals("algo@gmail.com", vehicle.getUser().getEmail());
        Assertions.assertEquals("Cliente", vehicle.getUser().getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                vehicle.getUser().getRols().get(0).getDescription());
        Assertions.assertFalse(vehicle.isEnable());
    }
}
