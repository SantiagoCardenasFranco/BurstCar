package com.uco.graduationproject.burstcar.infrastructure.user.adapter.entity;

import com.uco.graduationproject.burstcar.domain.model.Rol;
import com.uco.graduationproject.burstcar.infrastructure.rol.adapter.entity.EntityRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_app")
public class EntityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String identification;
    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "id_user")
    private List<EntityRol> roles;

    public EntityUser() {
    }

    public EntityUser(Long id, String identification, String name, String lastName, String email, String password, List<EntityRol> roles) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
