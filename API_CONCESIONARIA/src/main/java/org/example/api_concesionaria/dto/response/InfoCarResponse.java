package org.example.api_concesionaria.dto.response;

public record InfoCarResponse (
    String title_info,
    String description_info,
    Boolean is_left
) {
}
