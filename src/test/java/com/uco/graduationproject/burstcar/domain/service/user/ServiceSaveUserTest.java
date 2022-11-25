package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ServiceSaveUserTest {

    @Test
    void createUserSuccessful(){
        User user = new UserTestDataBuilder().byDefault().build();

        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(false);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);

        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);
        Long id = serviceSaveUser.executeSave(user);

        Mockito.verify(repositoryUser, Mockito.times(1)).saveUser(user);
        Mockito.verify(repositoryUser, Mockito.times(1)).existUser(user);
        Assertions.assertEquals(1L, id);
    }

    @Test
    void noCreateUser(){
        User user = new UserTestDataBuilder().byDefault().build();

        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(true);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);

        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);

        Assertions.assertEquals("Ya existe un usuario, favor de ingresar uno nuevo",
                Assertions.assertThrows(
                                IllegalArgumentException.class, ()-> serviceSaveUser.executeSave(user))
                .getMessage());
    }


}
