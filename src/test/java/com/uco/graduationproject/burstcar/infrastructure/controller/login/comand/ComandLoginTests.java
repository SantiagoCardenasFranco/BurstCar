package com.uco.graduationproject.burstcar.infrastructure.controller.login.comand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.graduationproject.burstcar.application.service.login.dto.DtoLogin;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.infrastructure.ApplicationMock;
import org.apache.commons.codec.digest.DigestUtils;
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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandLoginTests {

    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;

    @Test
    void loginUserSuccessful() throws Exception {
        DtoLogin login = new ComandLoginTestDataBuilder().byDefault().build();

        mocMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        User user = repositoryUser.consultUser(login.getEmail(),
                DigestUtils.sha256Hex(login.getPassword()));

        Assertions.assertEquals("987654320", user.getIdentification());
        Assertions.assertEquals("Nombre", user.getName());
        Assertions.assertEquals("Apellido", user.getLastName());
        Assertions.assertEquals("Nuevocorreo@gmailcom", user.getEmail());
        Assertions.assertEquals("f8bfb481b5e42e7f984c2f450701915eeab771107779221948a0973f5320e87a", user.getPassword());
        Assertions.assertEquals("Cliente", user.getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio", user.getRols().get(0).getDescription());

    }

    @Test
    void noLoginUser() throws Exception {
        DtoLogin login = new ComandLoginTestDataBuilder().byDefault()
                .withEmail("1@gmail.com").build();

        mocMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("exceptionName", is("IllegalStateException")))
                .andExpect(jsonPath("message", is("Email o contraseña incorrecta")));
    }

}
