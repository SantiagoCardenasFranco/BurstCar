package com.uco.graduationproject.burstcar.infrastructure.controller.vehiclefeatures.consult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
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
class ConsultVehicleFeatureTests {

    @Autowired
    private RepositoryVehicleFeature repositoryVehicleFeature;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultAllVehicleFeatures() throws Exception{
        mocMvc.perform(get("/vehicle/feature/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].licensePlate", is("XSB-86S")))
                .andExpect(jsonPath("$[0].model", is("2022")))
                .andExpect(jsonPath("$[0].brand", is("Chevrolet")))
                .andExpect(jsonPath("$[1].licensePlate", is("XTW-56B")))
                .andExpect(jsonPath("$[1].model", is("2018")))
                .andExpect(jsonPath("$[1].brand", is("Nissan")));
    }

    @Test
    void consulVehicleFeaturesByLicensePlate() throws Exception{
        mocMvc.perform(get("/vehicle/feature/XTW-56B")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("licensePlate", is("XTW-56B")))
                .andExpect(jsonPath("model", is("2018")))
                .andExpect(jsonPath("brand", is("Nissan")));
    }
}
