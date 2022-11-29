package com.uco.graduationproject.burstcar.infrastructure.controller.vehiclefeatures.comand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.application.service.vehiclefeature.comand.dto.DtoSaveVehicleFeature;
import com.uco.graduationproject.burstcar.application.service.vehicleservice.comand.dto.DtoSaveVehicleService;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.port.service.RepositoryService;
import com.uco.graduationproject.burstcar.domain.port.vehiclefeatures.RepositoryVehicleFeature;
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
class ComandVehicleFeatureTests {

    @Autowired
    private RepositoryVehicleFeature repositoryVehicleFeature;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void createVehicleFeatureSuccessful() throws Exception {
        DtoSaveVehicleFeature vehicleFeature = new ComandVehicleFeatureTestsDataBuilder().byDefault().build();

        MvcResult resultado = mocMvc.perform(post("/vehicle/feature/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleFeature)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonResult, Response.class);

        VehicleFeatures features = repositoryVehicleFeature.findFeatures(vehicleFeature.getLicensePlate());

        Assertions.assertEquals(1, response.getValor());
        Assertions.assertEquals("QRD-98H", features.getLicensePlate());
        Assertions.assertEquals("Mercedez", features.getBrand());
        Assertions.assertEquals("2022", features.getModel());
    }


    @Test
    void noCreateVehicleFeatureBecauseItWasAlreadyCreated() throws Exception {
        DtoSaveVehicleFeature vehicleFeature = new ComandVehicleFeatureTestsDataBuilder().byDefault()
                .withLicensePlate("XTW-56B").withBrand("Nissan").withModel("2018").build();

        mocMvc.perform(post("/vehicle/feature/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleFeature)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("Estas castacteristicas de su vehiculo es muy parecida a una que ya está " +
                        "registrada, por favor ingrese de nuevo los datos")));
    }

    @Test
    void updateVehicleFeatureSuccessful() throws Exception {
        DtoSaveVehicleFeature vehicleFeature = new ComandVehicleFeatureTestsDataBuilder().byDefault()
                .withLicensePlate("XTW-56B").withBrand("Mazda").withModel("2023").build();


        mocMvc.perform(put("/vehicle/feature/update/" + 33)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleFeature)))
                .andExpect(status().is2xxSuccessful());

        VehicleFeatures vehicleFeatures = repositoryVehicleFeature.findFeatures(vehicleFeature.getLicensePlate());

        Assertions.assertEquals("XTW-56B", vehicleFeatures.getLicensePlate());
        Assertions.assertEquals("Mazda", vehicleFeatures.getBrand());
        Assertions.assertEquals("2023", vehicleFeatures.getModel());
    }

    @Test
    void noUpdateVehicleFeatureBecauseNoExists() throws Exception {
        DtoSaveVehicleFeature vehicleFeature = new ComandVehicleFeatureTestsDataBuilder().byDefault()
                .withBrand("Mazda").withModel("2023").build();

        mocMvc.perform(put("/vehicle/feature/update/" + 33)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicleFeature)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("No existe ese vehiculo")));
    }

}
