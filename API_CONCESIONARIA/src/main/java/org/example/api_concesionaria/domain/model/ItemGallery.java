package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public record ItemGallery(
        UUID id,
        String urlImgItem,
        UUID id_gallery
) {
}
