package com.uco.graduationproject.burstcar.domain.port.user;

import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.model.User;
import java.util.List;

public interface RepositoryUser {
    List<DtoUserSummary> listUser();
    Long saveUser(User user);
    boolean existUser(User user);
    void updateUser(Long id, User user);
    User consultUser(String email, String password);
    DtoUserSummary consultByIdentification(String identification);

}
