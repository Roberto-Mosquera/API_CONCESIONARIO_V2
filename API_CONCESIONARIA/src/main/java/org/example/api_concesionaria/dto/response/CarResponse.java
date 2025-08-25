package org.example.api_concesionaria.dto.response;

import java.util.List;

public record CarResponse(
    String nameCar,
    String urlImgCar,
    Double price,
    Integer stock,
    String brand,
    String model,
    String engine,
    String traction,
    String transmission,
    String torque,
    String speed,
    String urlTechnicalSheet,
    String nameCategory,
    GalleryCarResponse gallery,
    List<ColorCarResponse>carResponses,
    List<InfoCarResponse>infoCarResponses
) {
    
}
