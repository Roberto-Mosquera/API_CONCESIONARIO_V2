package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public record CategoryCar(
        UUID id,
        String nameCategory,
        Boolean enabled
) {

}
