package com.uco.graduationproject.burstcar.infrastructure.repository.additonaldata.adapter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "additional_data")
public class EntityAdditionalData {

    @Id
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "type_data", length = 255)
    private String typeData;

    public EntityAdditionalData(Integer quantity, String typeData) {
        this.quantity = quantity;
        this.typeData = typeData;
    }

    public EntityAdditionalData() {
    }
}
