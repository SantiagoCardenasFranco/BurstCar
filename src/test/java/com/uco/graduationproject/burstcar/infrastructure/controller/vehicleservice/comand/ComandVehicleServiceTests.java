package com.uco.graduationproject.burstcar.infrastructure.controller.vehicleservice.comand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
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
class ComandVehicleServiceTests {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void createVehicleServiceSuccessful() throws Exception {
        DtoSaveVehicleService vehicleService = new ComandVehicleServiceTestsDataBuilder().byDefault().build();

        MvcResult resultado = mocMvc.perform(post("/vehicle/service/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleService)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonResult, Response.class);

        VehicleService vehicle = repositoryService.findByName(vehicleService.getNameService());

        Assertions.assertEquals(1, response.getValor());
        Assertions.assertEquals("Transporte producto", vehicle.getNameService());
        Assertions.assertEquals("Encaragdo de llevar productos de un punto a otro", vehicle.getDescriptionService());
    }

    @Test
    void noCreateVehicleServiceBecauseItWasAlreadyCreated() throws Exception {
        DtoSaveVehicleService vehicleService = new ComandVehicleServiceTestsDataBuilder().byDefault()
                .withNameService("Carga").withDescriptionService("Encargado de transportar todo material")
                .build();


        mocMvc.perform(post("/vehicle/service/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleService)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("Este servicio ya se encuentra registrado, porfavor verificar")));
    }


    @Test
    void updateVehicleServiceSuccessful() throws Exception {
        DtoSaveVehicleService vehicleService = new ComandVehicleServiceTestsDataBuilder().byDefault()
                .withNameService("Transporte").build();


        mocMvc.perform(put("/vehicle/service/update/" + 4)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleService)))
                .andExpect(status().is2xxSuccessful());

        VehicleService service = repositoryService.findByName(vehicleService.getNameService());

        Assertions.assertEquals("Transporte", service.getNameService());
        Assertions.assertEquals("Encaragdo de llevar productos de un punto a otro", service.getDescriptionService());
    }


    @Test
    void noUpdateVehicleServiceBecauseNoExists() throws Exception {
        DtoSaveVehicleService vehicleService = new ComandVehicleServiceTestsDataBuilder().byDefault()
                .withNameService("Transporte paseo").withDescriptionService("Viajar hasta cierto punto").build();

        mocMvc.perform(put("/vehicle/service/update/" + 4)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleService)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("No existe ese servicio")));
    }

}
