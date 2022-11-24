package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.VehicleFeatureTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleFeatureTest {

    @Test
    void validateCreationSuccessful() {
        VehicleFeatures vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();

        Assertions.assertEquals("XAS-42A", vehicleFeatures.getLicensePlate());
        Assertions.assertEquals("2023", vehicleFeatures.getModel());
        Assertions.assertEquals("Chevrolet", vehicleFeatures.getBrand());
    }

    @Test
    void validateFieldsMissingLicensePlate() {
        Assertions.assertEquals("Un vehiculo siempre debe tener matricula",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withLicensePlate("").
                                build()).getMessage());
    }

    @Test
    void validateFieldsMissingModel() {
        Assertions.assertEquals("Un vehiculo debe de tener un modelo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withModel("")
                                .build()).getMessage());
    }

    @Test
    void validateFieldsMissingBrand() {
        Assertions.assertEquals("Un vehiculo es de una marca",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withBrand("")
                                .build()).getMessage());
    }

    @Test
    void validateFieldsNullLicensePlate() {
        Assertions.assertEquals("Un vehiculo siempre debe tener matricula",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withLicensePlate(null).
                                build()).getMessage());
    }

    @Test
    void validateFieldsNullModel() {
        Assertions.assertEquals("Un vehiculo debe de tener un modelo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withModel(null)
                                .build()).getMessage());
    }

    @Test
    void validateFieldsNullBrand() {
        Assertions.assertEquals("Un vehiculo es de una marca",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new VehicleFeatureTestDataBuilder().byDefault().withBrand(null)
                                .build()).getMessage());
    }
}
