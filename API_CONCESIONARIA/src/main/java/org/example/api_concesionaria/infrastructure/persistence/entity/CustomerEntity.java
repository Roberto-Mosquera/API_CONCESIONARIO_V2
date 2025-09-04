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

    @Column(length = 30,nullable = false,name = "first_name")
    private String firstName;
    @Column(length = 30,nullable = false,name = "middle_name")
    private String middleName;
    @Column(length = 30,nullable = false,name = "paternal_surname")
    private String paternalSurname;
    @Column(length = 30,nullable = false,name = "maternal_surname")
    private String maternalSurname;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 12,nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "document",name = "type_document")
    private TypeDocument typeDocument;

    @Column(length = 15,unique = true,name = "document_text")
    private String documentText;

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
