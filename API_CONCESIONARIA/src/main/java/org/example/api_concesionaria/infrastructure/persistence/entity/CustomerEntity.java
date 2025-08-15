package org.example.api_concesionaria.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private UUID id;

    private String first_name;

    private String middle_name;

    private String paternal_surname;

    private String maternal_surname;

    private String email;

    private String phone;

    private String type_document;

    private String document_text;

    private Boolean enabled = Boolean.FALSE;

    @OneToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "id_user"
    )
    private UserEntity user;
}
