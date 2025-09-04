package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public record GalleryCar(
        UUID id,
        String nameGallery,
        Boolean enabled,
        UUID id_car
) {
}
