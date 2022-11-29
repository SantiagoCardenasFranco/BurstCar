package com.uco.graduationproject.burstcar.infrastructure.controller.user.comand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.application.service.user.comand.dto.DtoSaveUser;
import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandUserTests {

    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void createUserSuccessful() throws Exception {
        DtoSaveUser comandUserTestsDataBuilder = new ComandUserTestsDataBuilder()
                .byDefault().withIdentification("892").withEmail("34@gamil.com")
                .withPassword("w9Snpo<code>t0d0").build();

        MvcResult resultado = mocMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandUserTestsDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonResult, Response.class);

        DtoUserSummary userCreated = repositoryUser.consultByIdentification(comandUserTestsDataBuilder.getIdentification());

        Assertions.assertEquals(1, response.getValor());
        Assertions.assertEquals("892", userCreated.getIdentification());
        Assertions.assertEquals("Nombre", userCreated.getName());
        Assertions.assertEquals("Apellido", userCreated.getLastName());
        Assertions.assertEquals("34@gamil.com", userCreated.getEmail());
        Assertions.assertEquals("Cliente", userCreated.getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                userCreated.getRols().get(0).getDescription());
    }

    @Test
    void noCreateUserPasswordIncorrect() throws Exception {
        DtoSaveUser comandUserTestsDataBuilder = new ComandUserTestsDataBuilder()
                .byDefault().withIdentification("892").withEmail("34@gamil.com")
                .withPassword("w992802z*Snpo<code>t0d0").build();

        mocMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandUserTestsDataBuilder)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("La contarseña no es permitida")));
    }

    @Test
    void noCreateUserBecauseItWasAlreadyCreated() throws Exception {
        DtoSaveUser comandUserTestsDataBuilder = new ComandUserTestsDataBuilder()
                .byDefault().withName("nombre").withLastName("Algo").withIdentification("123456789")
                .withPassword("w9Inpo<code>t0d0").withEmail("12@gmail.com").build();

        mocMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandUserTestsDataBuilder)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("Ya existe un usuario, favor de ingresar uno nuevo")));
    }

    @Test
    void updateUserSuccessful() throws Exception {
        DtoSaveUser comandUserTestsDataBuilder = new ComandUserTestsDataBuilder()
                .byDefault().withIdentification("7846708").withEmail("nuevoCorreo@gamil.com")
                .withPassword("w5Mnpo<code>t0d0").build();

        mocMvc.perform(put("/user/update/" + 45)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandUserTestsDataBuilder)))
                .andExpect(status().is2xxSuccessful());

        DtoUserSummary userUpdate = repositoryUser.consultByIdentification(comandUserTestsDataBuilder.getIdentification());

        Assertions.assertEquals("7846708", userUpdate.getIdentification());
        Assertions.assertEquals("Nombre", userUpdate.getName());
        Assertions.assertEquals("Apellido", userUpdate.getLastName());
        Assertions.assertEquals("nuevoCorreo@gamil.com", userUpdate.getEmail());
        Assertions.assertEquals("Cliente", userUpdate.getRols().get(0).getName());
    }

    @Test
    void noUpdateUserBecauseNoExists() throws Exception {
        DtoSaveUser comandUserTestsDataBuilder = new ComandUserTestsDataBuilder()
                .byDefault().withName("nombre").withLastName("Algo").withIdentification("87654323456")
                .withPassword("w8Inpo<code>t0d0").withEmail("jeje@gmail.com").build();

        mocMvc.perform(put("/user/update/" + 45)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandUserTestsDataBuilder)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("No existe ese usuario")));
    }

}
