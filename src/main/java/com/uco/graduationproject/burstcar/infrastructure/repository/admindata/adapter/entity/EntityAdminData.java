package com.uco.graduationproject.burstcar.infrastructure.repository.admindata.adapter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "admin_data")
public class EntityAdminData {

    @Id
    private Long id;
    private String info;
    private String password;

    public EntityAdminData(String info, String password) {
        this.info = info;
        this.password = password;
    }

    public EntityAdminData() {
    }
}
