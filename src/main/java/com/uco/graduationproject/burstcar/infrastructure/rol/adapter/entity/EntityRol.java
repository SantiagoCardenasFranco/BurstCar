package com.uco.graduationproject.burstcar.infrastructure.rol.adapter.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "rol_user")
public class EntityRol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String  name;
    private String description;


    public EntityRol() {
    }

    public EntityRol(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
