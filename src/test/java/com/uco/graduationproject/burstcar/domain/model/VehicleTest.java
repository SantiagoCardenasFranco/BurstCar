package com.uco.graduationproject.burstcar.domain.model;


import com.uco.graduationproject.burstcar.domain.testdatabuilder.VehicleTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void validateCreationSuccessful() {
        Vehicle vehicle = new VehicleTestDataBuilder().byDefault().build();

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
        Assertions.assertEquals("w9Inpo<code>t0d0", vehicle.getUser().getPassword());
        Assertions.assertEquals("Cliente", vehicle.getUser().getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                vehicle.getUser().getRols().get(0).getDescription());
        Assertions.assertFalse(vehicle.isEnable());
    }

    @Test
    void validateFieldsNullVehicleFeatures() {
        Assertions.assertEquals("Las carateristcas de un auto siempre se deben registra",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleTestDataBuilder().byDefault().withVehicleFeatures(null).build()).getMessage());
    }

    @Test
    void validateFieldsNullVehicleService() {
        Assertions.assertEquals("Un auto debe se brindar un servicio",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleTestDataBuilder().byDefault().withVehicleService(null).build()).getMessage());
    }

    @Test
    void validateFieldsNullUser() {
        Assertions.assertEquals("Un vehiculo tiene un usuario",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleTestDataBuilder().byDefault().withUser(null).build()).getMessage());
    }
}
