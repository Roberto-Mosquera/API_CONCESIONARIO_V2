package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "color_car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColorCarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_color_car")
    private UUID id;

    @Column(length = 20)
    private String name_color;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url_img_color;

    @Column( nullable = false)
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
