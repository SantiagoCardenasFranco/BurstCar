package com.uco.graduationproject.burstcar.domain.service.user;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.port.user.RepositoryUser;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.dto.DtoUserSummaryTestDataBuilder;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ServiceFindUserTest {

    @Test
    void findUserSuccessful(){
        User user = new UserTestDataBuilder().byDefault().build();
        DtoUserSummary dto = new DtoUserSummaryTestDataBuilder().byDefault()
                .withIdentification(user.getIdentification()).withName(user.getName())
                .withLastName(user.getLastName()).withEmail(user.getEmail()).withRols(user.getRols()).build();

        //Create
        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(false);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);
        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);
        serviceSaveUser.executeSave(user);

        //Find
        RepositoryUser repositoryUserFind = Mockito.mock(RepositoryUser.class);
        when(repositoryUserFind.consultByIdentification(Mockito.any())).thenReturn(dto);
        ServiceFindUser serviceFindUser = new ServiceFindUser(repositoryUserFind);
        DtoUserSummary userFind = serviceFindUser.executeFind(dto.getIdentification());

        Assertions.assertEquals(userFind.getIdentification(), dto.getIdentification());
        Assertions.assertEquals(userFind.getName(), dto.getName());
        Assertions.assertEquals(userFind.getLastName(), dto.getLastName());
        Assertions.assertEquals(userFind.getEmail(), dto.getEmail());
        Assertions.assertEquals(userFind.getRols().get(0).getName(), dto.getRols().get(0).getName());
        Assertions.assertEquals(userFind.getRols().get(0).getDescription(), dto.getRols().get(0)
                .getDescription());
    }

    @Test
    void noFindUser(){
        User user = new UserTestDataBuilder().byDefault().build();
        DtoUserSummary dto = new DtoUserSummaryTestDataBuilder().byDefault()
                .withName(user.getName()).withLastName(user.getLastName()).withEmail(user.getEmail())
                .withRols(user.getRols()).build();

        //Create
        RepositoryUser repositoryUser = Mockito.mock(RepositoryUser.class);
        when(repositoryUser.existUser(Mockito.any())).thenReturn(false);
        when(repositoryUser.saveUser(Mockito.any())).thenReturn(1L);
        ServiceSaveUser serviceSaveUser = new ServiceSaveUser(repositoryUser);
        serviceSaveUser.executeSave(user);

        //Find
        RepositoryUser repositoryUserFind = Mockito.mock(RepositoryUser.class);
        when(repositoryUserFind.consultByIdentification(Mockito.any())).thenReturn(null);
        ServiceFindUser serviceFindUser = new ServiceFindUser(repositoryUserFind);

        Assertions.assertEquals("No se encontró a ningún usuario", Assertions.assertThrows(
                        IllegalArgumentException.class,
                        ()-> serviceFindUser.executeFind(dto.getIdentification())).getMessage());
    }
}
