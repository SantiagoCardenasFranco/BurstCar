package com.uco.graduationproject.burstcar.domain.dto;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoAdditionalDataTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DtoAdditionalDataTest {

    @Test
    void validateCreationSuccessful() {
        DtoAdditionalData dto = new DtoAdditionalDataTestDataBuilder().byDefault().build();

        Assertions.assertEquals(1, dto.getId());
        Assertions.assertEquals(10, dto.getQuantity());
        Assertions.assertEquals("Usuarios registrados", dto.getTypeData());
    }
}
