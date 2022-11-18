package com.uco.graduationproject.burstcar.infrastructure.repository.user.adapter.entity;

import com.uco.graduationproject.burstcar.infrastructure.repository.rol.adapter.entity.EntityRol;
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
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String identification;
    @Column(length = 20)
    private String name;

    @Column(name = "last_name", length = 30)
    private String lastName;
    @Column(length = 50, unique = true)
    private String email;
    @Column(unique = true)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "id_user")
    private List<EntityRol> roles;

    public EntityUser() {
    }

    public EntityUser(String identification, String name, String lastName, String email, String password, List<EntityRol> roles) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}