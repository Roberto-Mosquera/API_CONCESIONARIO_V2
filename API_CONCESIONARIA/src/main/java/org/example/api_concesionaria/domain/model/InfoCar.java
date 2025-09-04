package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public record InfoCar(
        UUID id,
        String titleInfo,
        String descriptionInfo,
        Boolean isLeft,
        Boolean enabled,
        UUID id_car
) {
}
