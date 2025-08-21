package org.example.api_concesionaria.dto.response;

import java.util.UUID;

public record CategoryCarResponse(
        UUID id,
        String nameCategory
) {
}
