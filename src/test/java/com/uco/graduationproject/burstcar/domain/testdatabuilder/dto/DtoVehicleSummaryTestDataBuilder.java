package com.uco.graduationproject.burstcar.domain.testdatabuilder.dto;


import com.uco.graduationproject.burstcar.domain.dto.DtoUserSummary;
import com.uco.graduationproject.burstcar.domain.dto.DtoVehicleSummary;
import com.uco.graduationproject.burstcar.domain.model.VehicleFeatures;
import com.uco.graduationproject.burstcar.domain.model.VehicleService;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleFeatureTestDataBuilder;
import com.uco.graduationproject.burstcar.domain.testdatabuilder.model.VehicleServiceTestDataBuilder;

public class DtoVehicleSummaryTestDataBuilder {

    private VehicleFeatures vehicleFeatures;
    private VehicleService vehicleService;
    private DtoUserSummary user;
    private boolean isEnable;

    public DtoVehicleSummaryTestDataBuilder byDefault() {
        this.vehicleFeatures = new VehicleFeatureTestDataBuilder().byDefault().build();
        this.vehicleService = new VehicleServiceTestDataBuilder().byDefault().build();
        this.user = new DtoUserSummaryTestDataBuilder().byDefault().build();
        this.isEnable = false;
        return this;
    }

    public DtoVehicleSummaryTestDataBuilder withVehicleFeatures(VehicleFeatures vehicleFeatures){
        this.vehicleFeatures = vehicleFeatures;
        return this;
    }

    public DtoVehicleSummaryTestDataBuilder withVehicleService(VehicleService vehicleService){
        this.vehicleService = vehicleService;
        return this;
    }

    public DtoVehicleSummaryTestDataBuilder withUser(DtoUserSummary user){
        this.user = user;
        return this;
    }

    public DtoVehicleSummaryTestDataBuilder withEnable(boolean isEnable){
        this.isEnable = isEnable;
        return this;
    }

    public DtoVehicleSummary build(){
        return new DtoVehicleSummary(vehicleFeatures, vehicleService, user, isEnable);
    }
}
