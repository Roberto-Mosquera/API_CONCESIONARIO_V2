package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.api_concesionaria.Enum.RoleUser;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private UUID id;

    @Column(unique = true,length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleUser role_user;

    private Boolean enabled = Boolean.FALSE;

}
