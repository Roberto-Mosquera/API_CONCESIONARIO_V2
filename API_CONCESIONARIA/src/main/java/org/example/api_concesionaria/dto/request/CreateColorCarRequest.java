package org.example.api_concesionaria.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record CreateColorCarRequest(
        String nameColor,
        MultipartFile urlImgColor,
        UUID id_car
) {
}
