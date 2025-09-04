package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "item_gallery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemGalleryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item_gallery")
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT",name = "url_img_item")
    private String urlImgItem;

    @ManyToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_gallery_car",
            referencedColumnName = "id_gallery_car"
    )
    private GalleryCarEntity galleryCar;

}
