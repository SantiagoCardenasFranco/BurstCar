package com.uco.graduationproject.burstcar.domain.port.vehicle;

import com.uco.graduationproject.burstcar.domain.model.Service;
import com.uco.graduationproject.burstcar.domain.model.User;
import com.uco.graduationproject.burstcar.domain.model.Vehicle;
import java.util.List;

public interface RepositoryVehicle {
    List<Vehicle> listVehicle();
    Long saveVehicle(Vehicle vehicle);
    boolean existsVehicle(Vehicle vehicle);
    Vehicle consultByUser(User user);
    List<Vehicle> consultByService(Service service);
}
