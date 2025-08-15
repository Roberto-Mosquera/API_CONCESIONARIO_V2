package org.example.api_concesionaria.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.api_concesionaria.Enum.TypeDocument;

import java.util.UUID;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private UUID id;

    @Column(length = 30,nullable = false)
    private String first_name;
    @Column(length = 30,nullable = false)
    private String middle_name;
    @Column(length = 30,nullable = false)
    private String paternal_surname;
    @Column(length = 30,nullable = false)
    private String maternal_surname;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 12,nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "document")
    private TypeDocument type_document;

    @Column(length = 15,unique = true)
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
