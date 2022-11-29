package com.uco.graduationproject.burstcar.infrastructure.controller.user.consult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
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
class ConsultUserTests {

    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultAllUsers() throws Exception{
        mocMvc.perform(get("/user/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].identification", is("123456789")))
                .andExpect(jsonPath("$[0].name", is("nombre")))
                .andExpect(jsonPath("$[0].lastName", is("Algo")))
                .andExpect(jsonPath("$[0].email", is("12@gmail.com")))
                .andExpect(jsonPath("$[0].rols[0].name", is("Cliente")))
                .andExpect(jsonPath("$[0].rols[0].description", is("Encargado de solicitar el servicio")))
                .andExpect(jsonPath("$[1].identification", is("9876543")));
    }

    @Test
    void consultUsersByIdentification() throws Exception{
        mocMvc.perform(get("/user/find?identification=9876543")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("identification", is("9876543")))
                .andExpect(jsonPath("name", is("nombre")))
                .andExpect(jsonPath("lastName", is("Algo")))
                .andExpect(jsonPath("email", is("1265@gmail.com")))
                .andExpect(jsonPath("rols[0].name", is("Conductor")))
                .andExpect(jsonPath("rols[0].description", is("Encargado de solicitar de transportador")))
                ;
    }

    @Test
    void noFindUsersByIdentification() throws Exception{
        mocMvc.perform(get("/user/find?identification=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalArgumentException")))
                .andExpect(jsonPath("message", is("No se encontró a ningún usuario")));
    }
}
