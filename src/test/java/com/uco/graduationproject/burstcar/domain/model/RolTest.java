package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.RolTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RolTest {

    @Test
    void validateCreationSuccessful() {
        Rol rol = new RolTestDataBuilder().byDefault().build();

        Assertions.assertEquals("Cliente", rol.getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                rol.getDescription());
    }

    @Test
    void validateFieldsMissingName() {
        Assertions.assertEquals("Un rol siempre debe tenr un nombre",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new RolTestDataBuilder().byDefault().withName("").build()).getMessage());
    }

    @Test
    void validateFieldsMissingDescription() {
        Assertions.assertEquals("Un rol siempre debe tener una descripción",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new RolTestDataBuilder().byDefault().withDescription("").build()).getMessage());
    }

    @Test
    void validateFieldsNullName() {
        Assertions.assertEquals("Un rol siempre debe tenr un nombre",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new RolTestDataBuilder().byDefault().withName(null).build()).getMessage());
    }

    @Test
    void validateFieldsNullDescription() {
        Assertions.assertEquals("Un rol siempre debe tener una descripción",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new RolTestDataBuilder().byDefault().withDescription(null).build()).getMessage());
    }
}
