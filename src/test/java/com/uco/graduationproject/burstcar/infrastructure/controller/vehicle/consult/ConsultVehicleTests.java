package com.uco.graduationproject.burstcar.infrastructure.controller.vehicle.consult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.port.vehicle.RepositoryVehicle;
import com.uco.graduationproject.burstcar.infrastructure.ApplicationMock;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultVehicleTests {

    @Autowired
    private RepositoryVehicle repositoryVehicle;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultAllVehicles() throws Exception{
        mocMvc.perform(get("/vehicle/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].vehicleFeatures.licensePlate", is("XSB-86S")))
                .andExpect(jsonPath("$[0].vehicleFeatures.model", is("2022")))
                .andExpect(jsonPath("$[0].vehicleFeatures.brand", is("Chevrolet")))
                .andExpect(jsonPath("$[0].vehicleService.nameService", is("Carga")))
                .andExpect(jsonPath("$[0].vehicleService.descriptionService", is("Encargado de transportar todo material")))
                .andExpect(jsonPath("$[0].user.identification", is("123456789")))
                .andExpect(jsonPath("$[0].user.name", is("nombre")))
                .andExpect(jsonPath("$[0].user.lastName", is("Algo")))
                .andExpect(jsonPath("$[0].user.email", is("12@gmail.com")))
                .andExpect(jsonPath("$[0].user.rols[0].name", is("Cliente")))
                .andExpect(jsonPath("$[0].user.rols[0].description", is("Encargado de solicitar el servicio")))
                .andExpect(jsonPath("$[0].enable", is(false)))
                .andExpect(jsonPath("$[1].vehicleFeatures.licensePlate", is("XTW-56B")))
                .andExpect(jsonPath("$[1].vehicleFeatures.model", is("2018")))
                .andExpect(jsonPath("$[1].vehicleFeatures.brand", is("Nissan")))
                .andExpect(jsonPath("$[1].vehicleService.nameService", is("Transporte")))
                .andExpect(jsonPath("$[1].vehicleService.descriptionService", is("Encargado de transportar personal")))
                .andExpect(jsonPath("$[1].user.identification", is("9876543")))
                .andExpect(jsonPath("$[1].user.name", is("nombre")))
                .andExpect(jsonPath("$[1].user.lastName", is("Algo")))
                .andExpect(jsonPath("$[1].user.email", is("1265@gmail.com")))
                .andExpect(jsonPath("$[1].user.rols[0].name", is("Conductor")))
                .andExpect(jsonPath("$[1].user.rols[0].description", is("Encargado de solicitar de transportador")))
                .andExpect(jsonPath("$[1].enable", is(false)));

    }

    @Test
    void consultVehicleByUserIdentification() throws Exception{
        mocMvc.perform(get("/vehicle/user/123456789")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("vehicleFeatures.licensePlate", is("XSB-86S")))
                .andExpect(jsonPath("vehicleFeatures.model", is("2022")))
                .andExpect(jsonPath("vehicleFeatures.brand", is("Chevrolet")))
                .andExpect(jsonPath("vehicleService.nameService", is("Carga")))
                .andExpect(jsonPath("vehicleService.descriptionService", is("Encargado de transportar todo material")))
                .andExpect(jsonPath("user.identification", is("123456789")))
                .andExpect(jsonPath("user.name", is("nombre")))
                .andExpect(jsonPath("user.lastName", is("Algo")))
                .andExpect(jsonPath("user.email", is("12@gmail.com")))
                .andExpect(jsonPath("user.rols[0].name", is("Cliente")))
                .andExpect(jsonPath("user.rols[0].description", is("Encargado de solicitar el servicio")))
                .andExpect(jsonPath("enable", is(false)));

    }

    @Test
    void consultVehicleByEnabledAndNameService() throws Exception{
        mocMvc.perform(get("/vehicle/enabled?isEnabled=false&nameService=Carga")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].vehicleFeatures.licensePlate", is("XSB-86S")))
                .andExpect(jsonPath("$[0].vehicleFeatures.model", is("2022")))
                .andExpect(jsonPath("$[0].vehicleFeatures.brand", is("Chevrolet")))
                .andExpect(jsonPath("$[0].vehicleService.nameService", is("Carga")))
                .andExpect(jsonPath("$[0].vehicleService.descriptionService", is("Encargado de transportar todo material")))
                .andExpect(jsonPath("$[0].user.identification", is("123456789")))
                .andExpect(jsonPath("$[0].user.name", is("nombre")))
                .andExpect(jsonPath("$[0].user.lastName", is("Algo")))
                .andExpect(jsonPath("$[0].user.email", is("12@gmail.com")))
                .andExpect(jsonPath("$[0].user.rols[0].name", is("Cliente")))
                .andExpect(jsonPath("$[0].user.rols[0].description", is("Encargado de solicitar el servicio")))
                .andExpect(jsonPath("$[0].enable", is(false)));
    }
}
