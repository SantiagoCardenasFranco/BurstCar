package com.uco.graduationproject.burstcar.domain.testdatabuilder.dto;

import com.uco.graduationproject.burstcar.domain.dto.DtoAdditionalData;

public class DtoAdditionalDataTestDataBuilder {

    private int id;
    private int quantity;
    private String typeData;

    public DtoAdditionalDataTestDataBuilder byDefault() {
        this.id = 1;
        this.quantity = 10;
        this.typeData = "Usuarios registrados";
        return this;
    }

    public DtoAdditionalDataTestDataBuilder withId(int id){
        this.id = id;
        return this;
    }

    public DtoAdditionalDataTestDataBuilder withQuantity(int quantity){
        this.quantity = quantity;
        return this;
    }

    public DtoAdditionalDataTestDataBuilder withTypeData(String typeData){
        this.typeData = typeData;
        return this;
    }

    public DtoAdditionalData build(){
        return new DtoAdditionalData(id, quantity, typeData);
    }
}
