package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.comand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.application.service.vehicle.comand.dto.DtoSaveVehicle;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.infrastructure.ApplicationMock;
import com.uco.graduationproject.burstcar.infrastructure.controller.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandVehicleTests {

    @Autowired
    private RepositoryVehicle repositoryVehicle;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void createVehicleSuccessful() throws Exception {
        DtoSaveVehicle vehicle = new ComandVehicleTestsDataBuilder().byDefault().build();

        MvcResult resultado = mocMvc.perform(post("/vehicle_user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonResult, Response.class);

        Assertions.assertEquals(1, response.getValor());
   }

}
