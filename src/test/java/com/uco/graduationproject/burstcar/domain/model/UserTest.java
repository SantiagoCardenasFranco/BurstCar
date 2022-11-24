package com.uco.graduationproject.burstcar.domain.model;

import com.uco.graduationproject.burstcar.domain.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {

    @Test
    void validateCreationSuccessful() {
        User user = new UserTestDataBuilder().byDefault().build();

        Assertions.assertEquals("1234567890", user.getIdentification());
        Assertions.assertEquals("Nombre", user.getName());
        Assertions.assertEquals("Apellido", user.getLastName());
        Assertions.assertEquals("algo@gmail.com", user.getEmail());
        Assertions.assertEquals("w9Inpo<code>t0d0", user.getPassword());
        Assertions.assertEquals("Cliente", user.getRols().get(0).getName());
        Assertions.assertEquals("Encargado de solicitar el servicio de algún conductor disponible",
                user.getRols().get(0).getDescription());
    }

    @Test
    void validateFieldsMissingIdentification() {
        Assertions.assertEquals("La identificación no puede ser nula",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withIdentification("").build()).getMessage());
    }

    @Test
    void validateFieldsMissingName() {
        Assertions.assertEquals("El nombre del usuraio no puede ser nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withName("").build()).getMessage());
    }

    @Test
    void validateFieldsMissingRol() {
        List<Rol> rols = new ArrayList<Rol>() ;
        Assertions.assertEquals("Un usuario siempre debe tenr un rol",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withRols(rols).build()).getMessage());
    }


    @Test
    void validateFieldsMissingEmail() {
        Assertions.assertEquals("El email no corresponde con una buena escritura",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withEmail("@gmail.com").build()).getMessage());
    }

    @Test
    void validateFieldsMissingEmailIncorrect() {

        Assertions.assertEquals("El email no corresponde con una buena escritura",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withEmail("@gmail.com").build()).getMessage());
    }

    @Test
    void validateFieldsIdentificationNull() {
        Assertions.assertEquals("La identificación no puede ser nula",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withIdentification(null).build()).getMessage());
    }

    @Test
    void validateFieldsNameNull() {
        Assertions.assertEquals("El nombre del usuraio no puede ser nulo",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withName(null).build()).getMessage());
    }

    @Test
    void validateFieldsRolNull() {
        Assertions.assertEquals("Un usuario siempre debe tenr un rol",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withRols(null).build()).getMessage());
    }


    @Test
    void validateFieldsEmailNull() {
        Assertions.assertEquals("El email no corresponde con una buena escritura",
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        new UserTestDataBuilder().byDefault().withEmail("@gmail.com").build()).getMessage());
    }

}
