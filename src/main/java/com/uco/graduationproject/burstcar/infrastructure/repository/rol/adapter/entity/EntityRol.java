package com.uco.graduationproject.burstcar.infrastructure.repository.rol.adapter.entity;

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
    @Column(length = 20, nullable = false)
    private String  name;
    private String description;


    public EntityRol() {
    }

    public EntityRol(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
