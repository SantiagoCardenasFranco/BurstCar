package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.RolTestDataBuilder;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ServiceUpdateUserTest {

    @Test
    void updateUserSuccessful(){
        Rol rol = new RolTestDataBuilder().withName("Conductor").withDescription(
                "Encardo de brindar servicio").byDefault().build();
        List<Rol> roles = Collections.singletonList(rol);

        User user = new UserTestDataBuilder().byDefault().build();
        User userUpdate = new UserTestDataBuilder().byDefault().withEmail("15@gmail.com")
                .withPassword("w10Inpo<code>t0d0").withRols(roles).build();

        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(false);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);
        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);
        Long id = serviceSaveUser.executeSave(user);

        RepositoryUser repositoryUserUpdate = Mockito.mock(RepositoryUser.class);
        when(repositoryUserUpdate.existUser(Mockito.any())).thenReturn(true);
        ServiceUpdateUser serviceUpdateUser = new ServiceUpdateUser(repositoryUserUpdate);
        serviceUpdateUser.executeUpdate(id, userUpdate);

        Mockito.verify(repositoryUserUpdate, Mockito.times(1)).updateUser(
                eq(id), eq(userUpdate));
    }

    @Test
    void updateUserNoSuccessful(){
        Rol rol = new RolTestDataBuilder().withName("Conductor").withDescription(
                "Encardo de brindar servicio").byDefault().build();
        List<Rol> roles = Collections.singletonList(rol);

        User user = new UserTestDataBuilder().byDefault().build();
        User userUpdate = new UserTestDataBuilder().byDefault().withEmail("15@gmail.com")
                .withPassword("w10Inpo<code>t0d0").withRols(roles).build();

        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(false);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);
        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);
        Long id = serviceSaveUser.executeSave(user);

        ServiceUpdateUser serviceUpdateUser = new ServiceUpdateUser(repositoryUser);

        Assertions.assertEquals("No existe ese usuario", Assertions.assertThrows(
                        IllegalArgumentException.class,
                        ()-> serviceUpdateUser.executeUpdate(id, userUpdate))
                .getMessage());
    }


}
