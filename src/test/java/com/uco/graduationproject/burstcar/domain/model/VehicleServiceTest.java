package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.VehicleServiceTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleServiceTest {

    @Test
    void validateCreationSuccessful() {
        VehicleService vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();

        Assertions.assertEquals("Carga", vehicleService.getNameService());
        Assertions.assertEquals("Encargado de llevar las cosas seguras de un lugar a otro",
                vehicleService.getDescriptionService());
    }

    @Test
    void validateFieldsMissingName() {
        Assertions.assertEquals("Un servicio siempre debe tenr un nombre",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleServiceTestDataBuilder().byDefault().withName("").
                                build()).getMessage());
    }

    @Test
    void validateFieldsMissingDescription() {
        Assertions.assertEquals("Un servicio siempre debe tener una descripción",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleServiceTestDataBuilder().byDefault().withDescription("")
                                .build()).getMessage());
    }

    @Test
    void validateFieldsNullName() {
        Assertions.assertEquals("Un servicio siempre debe tenr un nombre",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleServiceTestDataBuilder().byDefault().withName(null).
                                build()).getMessage());
    }

    @Test
    void validateFieldsNullDescription() {
        Assertions.assertEquals("Un servicio siempre debe tener una descripción",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleServiceTestDataBuilder().byDefault().withDescription(null).
                                build()).getMessage());
    }
}
