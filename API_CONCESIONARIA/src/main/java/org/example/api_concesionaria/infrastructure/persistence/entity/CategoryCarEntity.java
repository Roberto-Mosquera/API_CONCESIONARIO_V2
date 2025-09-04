package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "category_car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category")
    private UUID id;
    @Column(length = 30,nullable = false, unique = true,name = "nameCategory")
    private String nameCategory;
    private Boolean enabled = Boolean.FALSE;



}
