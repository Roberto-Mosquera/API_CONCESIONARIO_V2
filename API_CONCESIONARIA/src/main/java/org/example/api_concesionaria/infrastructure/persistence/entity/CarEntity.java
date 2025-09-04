package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    private UUID id;

    @Column( length = 50, nullable = false,name = "name_car")
    private String nameCar;

    @Column(nullable = false, columnDefinition = "TEXT",name = "url_img_car")
    private String urlImgCar;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String engine;

    @Column(length = 50, nullable = false)
    private String traction;

    @Column(length = 50, nullable = false)
    private String transmission;

    @Column(length = 50, nullable = false)
    private String torque;

    @Column(length = 50, nullable = false)
    private String speed;

    @Column(nullable = false, columnDefinition = "TEXT",name = "url_technical_sheet")
    private String urlTechnicalSheet;

    @Column(nullable = false)
    private Boolean enabled = Boolean.FALSE;

    @ManyToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_category",
            referencedColumnName = "id_category"
    )
    private CategoryCarEntity category;

}