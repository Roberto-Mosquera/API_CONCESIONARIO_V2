package org.example.api_concesionaria.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "info_car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfoCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_info_car")
    private UUID id;

    @Column(length = 50, nullable = false)
    private String title_info;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description_info;

    @Column(nullable = false)
    private Boolean is_left = Boolean.FALSE;

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
            name = "id_car",
            referencedColumnName = "id_car"
    )
    private CarEntity car;
}

