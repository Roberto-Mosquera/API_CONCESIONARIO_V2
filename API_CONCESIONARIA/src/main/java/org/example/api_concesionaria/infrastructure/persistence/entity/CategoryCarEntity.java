package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.api_concesionaria.domain.model.CategoryCar;

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
    @Column(length = 30,nullable = false, unique = true)
    private String name_category;
    private Boolean enabled = Boolean.FALSE;

    public CategoryCarEntity(String name_category) {
        this.name_category = name_category;
    }

}
