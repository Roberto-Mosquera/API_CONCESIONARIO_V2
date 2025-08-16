package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "gallery_car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GalleryCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_gallery_car")
    private UUID id;

    @Column(name = "name_gallery", length = 40, nullable = false)
    private String nameGallery;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = Boolean.FALSE;

    @OneToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_car",
            referencedColumnName = "id_car",
            unique = true
    )
    private CarEntity car;
}