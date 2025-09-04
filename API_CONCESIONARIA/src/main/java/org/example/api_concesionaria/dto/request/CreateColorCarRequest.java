package org.example.api_concesionaria.dto.request;

import java.util.UUID;

public record CreateColorCarRequest(
        String nameColor,
        String urlImgColor,
        UUID id_car
) {
}
