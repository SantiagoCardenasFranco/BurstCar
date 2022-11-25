package com.uco.graduationproject.burstcar.domain.dto;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoUserSummaryTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DtoUserSummaryTest {

    @Test
    void validateCreationSuccessful() {
        DtoUserSummary dto = new DtoUserSummaryTestDataBuilder().byDefault().build();

        Assertions.assertEquals("1234567890", dto.getIdentification());
        Assertions.assertEquals("Nombre", dto.getName());
        Assertions.assertEquals("Apellido", dto.getLastName());
        Assertions.assertEquals("algo@gmail.com", dto.getEmail());
        Assertions.assertEquals("Cliente", dto.getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                dto.getRols().get(0).getDescription());
    }
}
